package com.example.service;

import com.example.dto.StudentDTO;
import com.example.model.Student;

import java.util.List;

public interface EmployeeService {

    public List<Student> getStudents();

    public boolean createStudent(StudentDTO student);

    public Student getStudentById(int id);

    public void deleteStudentById(int id);

    public String getStudentByName();


    public int getCalculationResult(int id);


}
