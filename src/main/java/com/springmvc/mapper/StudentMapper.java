package com.springmvc.mapper;

import com.springmvc.dto.StudentDto;
import com.springmvc.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student ){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstname(student.getFirstname());
        studentDto.setLastname(student.getLastname());
        studentDto.setEmail(student.getEmail());

        return  studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto){

        Student student= new Student();
        student.setId(studentDto.getId());
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        student.setEmail(studentDto.getEmail());

        return student;
    }
}
