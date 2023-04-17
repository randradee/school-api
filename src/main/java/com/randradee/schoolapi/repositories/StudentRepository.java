package com.randradee.schoolapi.repositories;

import com.randradee.schoolapi.dtos.StudentDTO;
import com.randradee.schoolapi.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
    void delete(StudentModel student);
}
