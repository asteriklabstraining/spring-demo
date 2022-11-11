package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public List<Student> getStudent(){
        return studentService.getStudents();
    }

    @GetMapping(value = "/students/{id}") //{pathvariable}
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PostMapping(value = "/createstudent")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);

        return "Student Created update1 + update2";

    }

    @DeleteMapping(value = "/deletestudent/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "student with id: " + id + " has been deleted";
    }

}
