package com.libraryManagement.librarymanagemnetsystem.Service;

import com.libraryManagement.librarymanagemnetsystem.DTO.Request.BookRequestDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Response.BookResponseDto;
import com.libraryManagement.librarymanagemnetsystem.Entity.Author;
import com.libraryManagement.librarymanagemnetsystem.Entity.Book;
import com.libraryManagement.librarymanagemnetsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;


    public BookResponseDto addBook(BookRequestDto bookRequestDto) {

        // get the author object
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();


        Book book=new Book();
        book.setTittle(bookRequestDto.getTittle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBooks().add(book);
        authorRepository.save(author);  // will save both book and author // author boos added in author onject

        // create a response also
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTittle());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;

    }
}
