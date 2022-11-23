package com.example.service;

import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;
import com.example.model.Teacher;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImplV2 implements TeacherServiceV2{

    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public TeacherResponseDTO createTeacher(TeacherRequestDTO teacherRequestDTO) {
      Teacher teacher = new Teacher();
      teacher.setFirstName(teacherRequestDTO.getFirstName());
      teacher.setLastName(teacherRequestDTO.getLastName());
      teacher.setAge(teacherRequestDTO.getAge());

      Teacher dbTeacher = teacherRepository.save(teacher);

      TeacherResponseDTO teacherResponseDTO = new TeacherResponseDTO();
      teacherResponseDTO.setFirstName(dbTeacher.getFirstName());
      teacherResponseDTO.setId(dbTeacher.getId());
      teacherResponseDTO.setAge(dbTeacher.getAge());
        return teacherResponseDTO;
    }

    @Override
    public TeacherResponseDTO findTeacherById(long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        TeacherResponseDTO teacherResponseDTO = new TeacherResponseDTO();
        teacherResponseDTO.setFirstName(teacher.getFirstName());
        teacherResponseDTO.setId(teacher.getId());
        teacherResponseDTO.setAge(teacher.getAge());
        return teacherResponseDTO;
    }

    @Override
    public List<TeacherResponseDTO> findAllTeacher() {
        List<TeacherResponseDTO> teacherResponseDTOS = new ArrayList<>();
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        for(Teacher teacher: teachers){
            TeacherResponseDTO teacherResponseDTO = new TeacherResponseDTO();
            teacherResponseDTO.setFirstName(teacher.getFirstName());
            teacherResponseDTO.setId(teacher.getId());
            teacherResponseDTO.setAge(teacher.getAge());
            teacherResponseDTO.setLastName(teacher.getLastName());
            teacherResponseDTOS.add(teacherResponseDTO);
        }
        return teacherResponseDTOS;
    }
}
