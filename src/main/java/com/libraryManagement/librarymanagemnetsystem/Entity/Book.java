package com.libraryManagement.librarymanagemnetsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libraryManagement.librarymanagemnetsystem.Enum.Genre;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    ////
    private String tittle;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private boolean isIssued; //it is used for library card

    ////

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;


    ////CONECTED WITH TRANSACTIONS
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transactions> transactionsList=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;


}
