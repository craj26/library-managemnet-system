package com.libraryManagement.librarymanagemnetsystem.Repository;

import com.libraryManagement.librarymanagemnetsystem.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
