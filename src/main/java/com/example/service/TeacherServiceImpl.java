package com.example.service;
import com.example.dto.TeacherDTO;
import com.example.model.Teacher;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public boolean createTeacher(TeacherDTO teacher) {
        boolean isValid = true;
        if(isValid(teacher)){
            Teacher teacherEntity = new Teacher();
            teacherEntity.setFirstName(teacher.getFirstName());
            teacherEntity.setLastName(teacher.getLastName());
            teacherEntity.setPhoneNum(teacher.getPhoneNum());
            teacherEntity.setDepartmentId(teacher.getDepartmentId());
            teacherRepository.save(teacherEntity);

        }else{
            isValid = false;
        }
        return isValid;
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public String getTeacherByName() {
        //Need to implement later
        return "Teacher Found";
    }

    private boolean isValid(TeacherDTO teacher){
        boolean valid = true;
        try{
            long num = Integer.parseInt(teacher.getPhoneNum());
        }catch (Exception e){
            valid = false;
        }
        return true;
    }
}
