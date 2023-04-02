package com.libraryManagement.librarymanagemnetsystem.Entity;

import com.libraryManagement.librarymanagemnetsystem.Enum.CardStatus;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cardNo;


    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updationDate;


    @OneToOne
    @JoinColumn ///---->>>>>>>>> it is Used to create a primary Key Column in this table
    Student student;

    //connected WITH TRANSACTIONS
    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Transactions> transactionsList=new ArrayList<>();

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Book> bookIssued=new ArrayList<>();

}
