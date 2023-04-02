package com.libraryManagement.librarymanagemnetsystem.Entity;


import com.libraryManagement.librarymanagemnetsystem.Enum.TransactionStatus;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    private String transactionsNumber;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @CreatedDate
    private Date transactiondate;
    private boolean isIssuoperation;
    private String message;





    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;
}
