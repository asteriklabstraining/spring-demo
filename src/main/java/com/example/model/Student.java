package com.example.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Student {

    @Id
    @Column(name = "STUDENTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "ISACTIVE")
    private boolean isActive;

}
