package com.libraryManagement.librarymanagemnetsystem.DTO.Response;

import com.libraryManagement.librarymanagemnetsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    private String transanctionId;

    private String bookName;

    private TransactionStatus transactionStatus;
}
