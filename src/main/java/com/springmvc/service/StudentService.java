package com.springmvc.service;

import com.springmvc.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentid);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long studentid);
}
