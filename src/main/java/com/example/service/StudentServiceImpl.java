package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(){
        return (List<Student>)studentRepository.findAll();
    }
    @Override
    public void createStudent(Student student){
        studentRepository.save(student);
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

}
