package com.example.controller;

import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;
import com.example.service.TeacherService;
import com.example.service.TeacherServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequestMapping("/api/v2/teacher")
public class TeacherControllerv2 {

    @Autowired
    private TeacherServiceV2 teacherService;

    @PostMapping()
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody TeacherRequestDTO teacher){
        log.info("create teacher v2 controller method called");
        TeacherResponseDTO result= teacherService.createTeacher(teacher);
        String msg;
        HttpStatus httpStatus;
        if(result!=null){
            msg =  "Teacher Created";
            httpStatus = HttpStatus.CREATED;
        }else{
            msg = "Teacher couldn't be created";
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        log.info("create teacher controller method finished, returning response back to UI");
        return new ResponseEntity<>(result, httpStatus);
    }

    @GetMapping()
    public ResponseEntity<List<TeacherResponseDTO>> findAllTeacher(){
        log.info("find all teacher V2 version called");
        return new ResponseEntity<>(teacherService.findAllTeacher(), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteTeacher(){
        return new ResponseEntity<>("delete teacher called", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> updateTeacher(){
        return new ResponseEntity<>("update teacher called", HttpStatus.OK);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<TeacherResponseDTO> findTeacherById(@RequestParam("id") long id){
        log.info("find teacher by id V2 version called, {}", id);
        return new ResponseEntity<>(teacherService.findTeacherById(id), HttpStatus.OK);
    }
}
