package com.libraryManagement.librarymanagemnetsystem.Repository;

import com.libraryManagement.librarymanagemnetsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
