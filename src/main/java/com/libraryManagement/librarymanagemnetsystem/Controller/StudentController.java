package com.libraryManagement.librarymanagemnetsystem.Controller;


import com.libraryManagement.librarymanagemnetsystem.DTO.Request.StudentRequestDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Response.StudentResponseDto;
import com.libraryManagement.librarymanagemnetsystem.DTO.Request.StudentUpdateEmailRequestDto;
import com.libraryManagement.librarymanagemnetsystem.Enum.Department;
import com.libraryManagement.librarymanagemnetsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
        //return "Student ADDED SUCCESFULLY";
    }

    @GetMapping("/find_by_email")
    public  String findStudentByEmail(@RequestParam("email") String email){
        return studentService.findByEmail(email);

    }

    //getStudent of same department
    @GetMapping("/list_by_department")
    public List<String> list_by_department(@RequestParam("dment")Department department){
        List<String> studentlist=studentService.list_by_department(department);
        return studentlist;
    }

    //get STUDENT LIST OF SAME AGE
    @GetMapping("/find_by_age")
    public List<String> findByAge(@RequestParam("age") int age){
        List<String> student=studentService.findByAge(age);
        return student;
    }


    @PutMapping("/update_email")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
