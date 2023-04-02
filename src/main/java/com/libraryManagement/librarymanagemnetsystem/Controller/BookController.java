package com.libraryManagement.librarymanagemnetsystem.Controller;


import com.libraryManagement.librarymanagemnetsystem.DTO.Request.BookRequestDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Response.BookResponseDto;

import com.libraryManagement.librarymanagemnetsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }
}
