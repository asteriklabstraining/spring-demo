package com.example.service;

import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;

import java.util.List;

public interface TeacherService {

    public List<TeacherResponseDTO> getTeachers();

    public boolean createTeacher(TeacherRequestDTO teacher);

    public TeacherRequestDTO getTeacherById(long id);

    public void deleteTeacherById(long id);

    public List<TeacherRequestDTO> getTeacherByName(String teacherName);

    public TeacherResponseDTO findTeacherById(Long id);

}
