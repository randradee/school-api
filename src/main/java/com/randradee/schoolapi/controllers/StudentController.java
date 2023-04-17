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
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    ResponseEntity<Object> saveStudent(@RequestBody @Valid StudentDTO studentDTO){
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
        Optional<StudentModel> studentModelOptional = studentService.findById(id);
        if (studentModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id).get());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteStudentById(@PathVariable (value = "id") UUID id){
        Optional<StudentModel> studentModelOptional = studentService.findById(id);
        if (studentModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }
        studentService.delete(studentModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Estudante apagado com sucesso.");
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> updateStudentById(@PathVariable (value = "id") UUID id,
                                             @RequestBody @Valid StudentDTO studentDTO){
        Optional<StudentModel> studentModelOptional = studentService.findById(id);
        if (studentModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDTO, studentModel);
        studentModel.setDateOfBirth(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateById(studentModel));
    }
}
