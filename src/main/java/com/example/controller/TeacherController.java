package com.example.controller;

import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated

public class TeacherController {

    @Autowired
    @Qualifier("teacherService")
    private TeacherService teacherService;

    @GetMapping(value = "/teachers")
    public List<TeacherResponseDTO> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping(value = "/teachers/{id}")
    public TeacherRequestDTO getTeacherById(@PathVariable long id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping(value = "/findteacher/{name}")
    public List<TeacherRequestDTO> findTeacherByName(@PathVariable String name){
        return teacherService.getTeacherByName(name);
    }

    @DeleteMapping(value = "/deleteteacher/{id}")
    public void deleteTeacherById(@PathVariable long id) {
        teacherService.deleteTeacherById(id);
    }

    @PostMapping(value = "/createteacher")
    public ResponseEntity<String> createTeacher(@RequestBody TeacherRequestDTO teacher){
        boolean result= teacherService.createTeacher(teacher);
        String msg;
        HttpStatus httpStatus;
        if(result){
            msg =  "Teacher Created";
            httpStatus = HttpStatus.CREATED;
        }else{
            msg = "Teacher couldn't be created";
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(msg, httpStatus);
    }




}
