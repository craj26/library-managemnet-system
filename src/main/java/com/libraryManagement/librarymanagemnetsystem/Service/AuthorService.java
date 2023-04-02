package com.libraryManagement.librarymanagemnetsystem.Service;

import com.libraryManagement.librarymanagemnetsystem.DTO.Request.AuthorRequestDto;
import com.libraryManagement.librarymanagemnetsystem.Entity.Author;
import com.libraryManagement.librarymanagemnetsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(AuthorRequestDto authorRequestDto) {
        Author author=new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());
        author.setMobileNo(authorRequestDto.getMobileNo());

        authorRepository.save(author);
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
}
