package com.randradee.schoolapi.controllers;

import com.randradee.schoolapi.dtos.StudentDTO;
import com.randradee.schoolapi.models.StudentModel;
import com.randradee.schoolapi.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

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

    @GetMapping
    ResponseEntity<List<StudentModel>> getStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> getStudentById(@PathVariable (value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }
}
