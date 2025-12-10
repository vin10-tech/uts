package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRequest;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    
    private static final int LENGTH = 5; 

    public List<Student> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(entity -> mapToDto(entity))
                .collect(Collectors.toList());
    }
    private Student mapToDto(StudentEntity entity) {
        Student dto = new Student();
        dto.setNim(entity.getNim());
        dto.setFullName(entity.getFullName());
        dto.setDob(entity.getDob());
        dto.setAddress(entity.getAddress());
        return dto;
    }

    public Student addStudent(StudentRequest request) {
        StudentEntity entity = new StudentEntity();
        entity.setNim(generateNIM()); 
        entity.setFullName(request.getFullName());
        entity.setDob(request.getDob());
        entity.setAddress(request.getAddress());
        StudentEntity savedEntity = studentRepository.save(entity);
        return mapToDto(savedEntity);
    }

    private String generateNIM() {
        String maxNim = studentRepository.findMaxNim();
        return (maxNim == null) ? String.format("%0" + LENGTH + "d", 1)
                : String.format("%0" + LENGTH + "d", Integer.parseInt(maxNim) + 1);
    }
}
