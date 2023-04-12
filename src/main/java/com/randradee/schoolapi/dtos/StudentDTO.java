package com.randradee.schoolapi.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class StudentDTO {
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate dateOfBirth;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String street;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
}
