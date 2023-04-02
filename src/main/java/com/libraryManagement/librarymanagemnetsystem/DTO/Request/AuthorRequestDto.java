package com.libraryManagement.librarymanagemnetsystem.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorRequestDto {
    private String name;

    private int age;

    private String mobileNo;

    private String email;
}
