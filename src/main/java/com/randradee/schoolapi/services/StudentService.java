package com.randradee.schoolapi.services;

import com.randradee.schoolapi.models.StudentModel;
import com.randradee.schoolapi.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public StudentModel save(StudentModel student){
        return studentRepository.save(student);
    }

    public List<StudentModel> findAll(){
        return studentRepository.findAll();
    }

    public Optional<StudentModel> findById(UUID id) {
        return studentRepository.findById(id);
    }
}
