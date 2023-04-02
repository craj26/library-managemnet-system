package com.libraryManagement.librarymanagemnetsystem.Service;

import com.libraryManagement.librarymanagemnetsystem.DTO.Request.StudentRequestDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Response.StudentResponseDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Request.StudentUpdateEmailRequestDto;
import com.libraryManagement.librarymanagemnetsystem.Entity.LibraryCard;
import com.libraryManagement.librarymanagemnetsystem.Entity.Student;
import com.libraryManagement.librarymanagemnetsystem.Enum.CardStatus;
import com.libraryManagement.librarymanagemnetsystem.Enum.Department;
import com.libraryManagement.librarymanagemnetsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {

        //create a student object
        Student student=new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        //crate a libarycard object
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setStatus(CardStatus.ACTIVATED);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);

        //for StudentRESPONSEDTO

        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setName(studentRequestDto.getName());
        studentResponseDto.setEmail(studentRequestDto.getEmail());
        studentResponseDto.setId(student.getId());




        studentRepository.save(student);

        return studentResponseDto;

//        //set the value of car                   ///7
//        LibraryCard libraryCard=new LibraryCard();
//        libraryCard.setStatus(CardStatus.ACTIVATED);
//        libraryCard.setValidTill("26/01/2026");
//        libraryCard.setStudent(student);
//        //
//        //set the card attribute
//        student.setCard(libraryCard);
//
//        studentRepository.save(student);


    }


    public String findByEmail(String email) {
        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }


    public List<String> findByAge(int age) {
        List<Student> student=studentRepository.findByAge(age);
        List<String> studentName=new ArrayList<>();
        for(Student s:student){
            studentName.add(s.getName());
        }
        return  studentName;

    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto) {
        Student student=studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();//NOT UNDERSTOD
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        // update step
        Student updatedStudent = studentRepository.save(student);


        // convert updated student to response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return studentResponseDto;

    }

    //get Student list of same department
    public List<String> list_by_department(Department department) {
        List<Student> student=studentRepository.findByDepartment(department);
        List<String> studentName=new ArrayList<>();
        for(Student s:student){
            studentName.add(s.getName());
        }
        return  studentName;
    }
}
