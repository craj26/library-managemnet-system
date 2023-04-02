package com.libraryManagement.librarymanagemnetsystem.Repository;

import com.libraryManagement.librarymanagemnetsystem.Entity.Student;
import com.libraryManagement.librarymanagemnetsystem.Enum.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String email); //custom search based on attribute
    List<Student> findByAge(int age);

    List<Student> findByDepartment(Department department);


}
