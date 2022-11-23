package com.example.dto;

import lombok.Data;


@Data
public class TeacherRequestDTO {
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String departmentId;
    private String socialSecurity;
    private int age;
}
