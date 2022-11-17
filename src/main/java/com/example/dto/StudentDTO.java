package com.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentDTO {

    private String name;
    private String phoneNumber;

    private int rollNo;

    private String streetAddress;

}
