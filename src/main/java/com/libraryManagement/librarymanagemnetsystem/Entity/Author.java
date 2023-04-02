package com.libraryManagement.librarymanagemnetsystem.Entity;



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

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    ////
    private String name;
    private int age;
   //@Column(unique = true)
    private String mobileNo;
    @Column(nullable = false,unique = true)
    private String email;
    ////


    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();

}
