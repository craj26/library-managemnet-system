package com.libraryManagement.librarymanagemnetsystem.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookRequestDto {
    private int cardId;

    private int bookId;
}
