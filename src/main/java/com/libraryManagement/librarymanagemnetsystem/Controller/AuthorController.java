package com.libraryManagement.librarymanagemnetsystem.Controller;

import com.libraryManagement.librarymanagemnetsystem.DTO.Request.AuthorRequestDto;
import com.libraryManagement.librarymanagemnetsystem.Entity.Author;
import com.libraryManagement.librarymanagemnetsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        authorService.addAuthor(authorRequestDto);
        return "AUTHOR ADDED SUCCESFULLY";
    }


    @GetMapping("/get_authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    //get list of author books
}
