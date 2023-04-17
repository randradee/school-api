package com.randradee.schoolapi.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotBlank
    private String name;
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
