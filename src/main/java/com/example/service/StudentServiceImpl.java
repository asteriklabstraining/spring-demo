package com.example.service;

import com.example.dto.StudentDTO;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
@Slf4j
public class StudentServiceImpl implements EmployeeService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(){
        return (List<Student>)studentRepository.findAll();
    }
    @Override
    public boolean createStudent(StudentDTO student){
        boolean isValid = true;
        if(isValid(student)){
            Student studentEntity = new Student();
            studentEntity.setName(student.getName());
            studentEntity.setPhoneNumber(student.getPhoneNumber());
            studentEntity.setActive(true);
            studentRepository.save(studentEntity);
        }else{
            isValid = false;
        }
        return isValid;
    }
    @Override
    public Student getStudentById(int id){
        Student student =  studentRepository.findById(id).get();
        log.info(student.getName());
        log.info("result {}", student.getStudentId()*10);
        return student;
    }
    @Override
    public void deleteStudentById(int id){
        studentRepository.deleteById(id);
    }

    @Override
    public String getStudentByName(){
        return "student found";
    }



    private boolean isValid(StudentDTO student){
        boolean valid = true;
        try{
            long num = Integer.parseInt(student.getPhoneNumber());
        }catch (Exception e){
            valid = false;
        }

        return valid;
    }

    @Override
    public int getCalculationResult(int id) {
        Student student = studentRepository.findById(id).get();
        int studentId = student.getStudentId();
        return studentId*10;
    }



}
