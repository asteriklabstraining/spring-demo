package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudents();

    public void createStudent(Student student);

    public Student getStudentById(int id);

    public void deleteStudentById(int id);

    public String getStudentByName();

}
