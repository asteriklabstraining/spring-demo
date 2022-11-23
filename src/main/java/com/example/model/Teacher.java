package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "social_security")
    private String socialSecurity;

    @Column(name = "age")
    private Integer age;



}
