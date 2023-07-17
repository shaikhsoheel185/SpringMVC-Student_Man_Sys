package com.springmvc.service;

import com.springmvc.dto.StudentDto;
import com.springmvc.entity.Student;
import com.springmvc.mapper.StudentMapper;
import com.springmvc.repositry.StudentRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentSeviceImpl implements StudentService {

    StudentRepositry studentRepositry;

    public StudentSeviceImpl(StudentRepositry studentRepositry) {
        this.studentRepositry = studentRepositry;
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students =studentRepositry.findAll();
        List<StudentDto> studentDtos= students.stream()
                .map((student) ->StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student =StudentMapper.mapToStudent(studentDto);
        studentRepositry.save(student);

    }

    @Override
    public StudentDto getStudentById(Long studentid) {

        Student student= studentRepositry.findById(studentid).get();
        StudentDto studentDto =StudentMapper.mapToStudentDto(student);

        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {

        studentRepositry.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long studentid) {
        studentRepositry.deleteById(studentid);
    }
}
