package com.example.controller;

import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;
import com.example.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequestMapping("/api/v1")
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

    @GetMapping(value = "teacher/find")
    public TeacherResponseDTO findTeacherById(@RequestParam(name = "id") Long id){
        log.info("Find teacher by id with request param, {} received", id);
        return teacherService.findTeacherById(id);
    }

    @DeleteMapping(value = "/deleteteacher/{id}")
    public void deleteTeacherById(@PathVariable long id) {
        teacherService.deleteTeacherById(id);
    }

    @PostMapping(value = "/createteacher")
    public ResponseEntity<String> createTeacher(@RequestBody TeacherRequestDTO teacher){
        log.info("create teacher controller method called");
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
        log.info("create teacher controller method finished, returning response back to UI");
        return new ResponseEntity<>(msg, httpStatus);
    }




}
