package com.example.service;

import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeacherServiceV2 {
    TeacherResponseDTO createTeacher(TeacherRequestDTO teacher);

    TeacherResponseDTO findTeacherById(long id);

    List<TeacherResponseDTO> findAllTeacher();
}
