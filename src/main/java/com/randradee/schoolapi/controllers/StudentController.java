package com.randradee.schoolapi.controllers;

import com.randradee.schoolapi.dtos.StudentDTO;
import com.randradee.schoolapi.models.StudentModel;
import com.randradee.schoolapi.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    ResponseEntity<Object> saveStudent(@RequestBody @Valid StudentModel studentDTO){
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDTO, studentModel);
        studentModel.setDateOfBirth(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }
}
