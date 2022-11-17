package com.example.controller;
import com.example.dto.TeacherDTO;
import com.example.model.Teacher;
import com.example.service.TeacherService;
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

public class TeacherController {

    @Autowired
    @Qualifier("teacherService")
    private TeacherService teacherService;

    @GetMapping(value = "/teachers")
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping(value = "/teachers/{id}")
    public Teacher getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping(value = "/deleteteacher/{id}")
    public void deleteTeacherById(@PathVariable long id) {
        teacherService.deleteTeacherById(id);
    }

    @PostMapping(value = "/createteacher")
    public ResponseEntity<String> createTeacher(@RequestBody TeacherDTO teacher){
        boolean result= teacherService.createTeacher(teacher);
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




}
