package com.randradee.schoolapi.services;

import com.randradee.schoolapi.dtos.StudentDTO;
import com.randradee.schoolapi.models.StudentModel;
import com.randradee.schoolapi.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public StudentModel save(StudentModel student){
        return studentRepository.save(student);
    }
}
