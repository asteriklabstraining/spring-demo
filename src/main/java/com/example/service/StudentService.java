package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return (List<Student>)studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    public void deleteStudentById(int id){
        studentRepository.deleteById(id);
    }

}
