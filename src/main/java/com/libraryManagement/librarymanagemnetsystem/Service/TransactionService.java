package com.libraryManagement.librarymanagemnetsystem.Service;

import com.libraryManagement.librarymanagemnetsystem.DTO.Request.IssueBookRequestDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Response.IssueBookResponseDto;
import com.libraryManagement.librarymanagemnetsystem.Entity.Book;
import com.libraryManagement.librarymanagemnetsystem.Entity.LibraryCard;
import com.libraryManagement.librarymanagemnetsystem.Entity.Transactions;
import com.libraryManagement.librarymanagemnetsystem.Enum.CardStatus;
import com.libraryManagement.librarymanagemnetsystem.Enum.TransactionStatus;
import com.libraryManagement.librarymanagemnetsystem.Repository.BookRepository;
import com.libraryManagement.librarymanagemnetsystem.Repository.LibraryCardRepository;
import com.libraryManagement.librarymanagemnetsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    LibraryCardRepository libraryCardRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
        Transactions transaction=new Transactions();
        transaction.setTransactionsNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssuoperation(true);


        //step 1
        LibraryCard libraryCard;
        try{
            libraryCard = libraryCardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid card id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id");
        }

        //book
        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }

        // both and card and book are valid
        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);



        if(libraryCard.getStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not activated");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry! Book is already issued.");
            transactionRepository.save(transaction);
            throw new Exception("Sorry! Book is already issued.");
        }

        //I can issue a book

        transaction.setTransactionStatus(TransactionStatus.SUCESS);
        transaction.setMessage("Transaction was succesfull");

        book.setIssued(true);
        book.setLibraryCard(libraryCard);
        libraryCard.getTransactionsList().add(transaction);
        book.getTransactionsList().add(transaction);
        libraryCard.getBookIssued().add(book);

        //now the main line
        libraryCardRepository.save(libraryCard);

        //now for respomnse dto
        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setTransanctionId(transaction.getTransactionsNumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCESS);
        issueBookResponseDto.setBookName(book.getTittle());


        // send an email
        String text = "Congrats !!." + libraryCard.getStudent().getName()+ "You have been issued "+book.getTittle()+" book.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("maverickgamer21@gmail.com");
        message.setTo(libraryCard.getStudent().getEmail());
        message.setSubject("Issue Book Notification");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;








    }
}
