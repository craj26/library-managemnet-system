package com.libraryManagement.librarymanagemnetsystem.Repository;


import com.libraryManagement.librarymanagemnetsystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
