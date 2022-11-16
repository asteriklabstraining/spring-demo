package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.model.Student;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private EmployeeService employeeService;

    @GetMapping(value = "/students")
    public List<Student> getStudent(){
        return employeeService.getStudents();
    }

    @GetMapping(value = "/students/{id}") //{pathvariable}
    public Student getStudentById(@PathVariable int id){
        return employeeService.getStudentById(id);
    }

    @PostMapping(value = "/createstudent")
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDTO student){

         boolean result= employeeService.createStudent(student);
         String msg;
         HttpStatus httpStatus;
         if(result){
             msg =  "Student Created";
             httpStatus = HttpStatus.CREATED;
         }else{
            msg = "Student couldn't be created";
            httpStatus = HttpStatus.BAD_REQUEST;
         }

         return new ResponseEntity<>(msg, httpStatus);

    }

    @DeleteMapping(value = "/deletestudent/{id}")
    public String deleteStudentById(@PathVariable int id){
        employeeService.deleteStudentById(id);
        return "student with id: " + id + " has been deleted";
    }

    @PatchMapping(value = "/updatestudent/{id}")
    public String updateStudent(@PathVariable int id){
        return "student updated, id: "+id;
    }



}
