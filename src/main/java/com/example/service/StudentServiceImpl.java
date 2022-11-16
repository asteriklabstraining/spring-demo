package com.example.service;

import com.example.dto.StudentDTO;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
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
        return studentRepository.findById(id).get();
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

}
