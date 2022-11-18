package com.example.service;
import com.example.dto.TeacherRequestDTO;
import com.example.dto.TeacherResponseDTO;
import com.example.model.Teacher;
import com.example.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("teacherService")
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Value("${asterik.labs.department}")
    private String department;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public boolean createTeacher(TeacherRequestDTO teacher) {
        log.info("create teacher called");
        boolean isValid = true;
        if(isValid(teacher)){
            Teacher teacherEntity = new Teacher();
            teacherEntity.setFirstName(teacher.getFirstName());
            teacherEntity.setLastName(teacher.getLastName());
            teacherEntity.setPhoneNum(teacher.getPhoneNum());
            teacherEntity.setDepartmentId(department);
            teacherRepository.save(teacherEntity);

        }else{
            isValid = false;
        }
        log.info("craete teacher finished");
        return isValid;
    }

    @Override
    public List<TeacherResponseDTO> getTeachers() {
        log.error("I am error log");
        List<TeacherResponseDTO> teacherResponseDTO = new ArrayList<>();
      for(Teacher teacher: (List<Teacher>) teacherRepository.findAll()){
          TeacherResponseDTO teacherResponsedto = new TeacherResponseDTO();
            teacherResponsedto.setFirstName(teacher.getFirstName());
            teacherResponsedto.setLastName(teacher.getLastName());
            teacherResponseDTO.add(teacherResponsedto);
      }
      return teacherResponseDTO;
    }



    @Override
    public TeacherRequestDTO getTeacherById(long id) {
        Teacher teacher = teacherRepository.findById(id).get();
       TeacherRequestDTO teacherRequestDTO = new TeacherRequestDTO();
       teacherRequestDTO.setFirstName(teacher.getFirstName());
       teacherRequestDTO.setLastName(teacher.getLastName());

       return teacherRequestDTO;
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<TeacherRequestDTO> getTeacherByName(String teacherName) {
        List<Teacher> teacherEntities= teacherRepository.findTeacherByFirstName(teacherName);
        List<TeacherRequestDTO> teacherRequestDTOS = new ArrayList<>();
        for(Teacher teacher: teacherEntities){
            TeacherRequestDTO teacherRequestDTO = new TeacherRequestDTO();
            teacherRequestDTO.setFirstName(teacher.getFirstName());
            teacherRequestDTO.setLastName(teacher.getLastName());
            teacherRequestDTOS.add(teacherRequestDTO);
        }
        return teacherRequestDTOS;
    }

    private boolean isValid(TeacherRequestDTO teacher){
        boolean valid = true;
        try{
            long num = Integer.parseInt(teacher.getPhoneNum());
        }catch (Exception e){
            valid = false;
            log.error("phoneNumber is not a valid number, {}",teacher.getPhoneNum());
            log.error(e.getMessage());
        }
        return valid;
    }


}
