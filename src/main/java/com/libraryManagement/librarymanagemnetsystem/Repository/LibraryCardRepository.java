package com.libraryManagement.librarymanagemnetsystem.Repository;

import com.libraryManagement.librarymanagemnetsystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
}
