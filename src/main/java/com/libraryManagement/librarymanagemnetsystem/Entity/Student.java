package com.libraryManagement.librarymanagemnetsystem.Entity;

import com.libraryManagement.librarymanagemnetsystem.Enum.Department;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id //1
    @GeneratedValue(strategy = GenerationType.IDENTITY) //2 these are importantbto learn again
    private int id;

    ////
    private String name;
    private int age;
    @Enumerated(EnumType.STRING) ////3
    Department department;
    @Column(unique = true)///4
    private String email;
    ////

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL) //6
    LibraryCard libraryCard;

}
