package com.example.service;
import com.example.dto.TeacherDTO;
import com.example.model.Teacher;
import java.util.List;

public interface TeacherService {

    public List<Teacher> getTeachers();

    public boolean createTeacher(TeacherDTO teacher);

    public Teacher getTeacherById(long id);

    public void deleteTeacherById(long id);

    public String getTeacherByName();

}
