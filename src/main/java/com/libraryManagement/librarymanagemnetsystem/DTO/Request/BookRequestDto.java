package com.libraryManagement.librarymanagemnetsystem.DTO.Request;

import com.libraryManagement.librarymanagemnetsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String tittle;

    private int price;

    private Genre genre;

    private int authorId;
}
