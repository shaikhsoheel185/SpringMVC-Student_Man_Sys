package com.springmvc.controller;

import com.springmvc.dto.StudentDto;
import com.springmvc.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;






// http://localhost:8080/students  ---------------- this  is home  Url




@Controller
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handler Method to handle Get All Students request

    @GetMapping("students")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }


    // Handler Method to handle new Student request
    @GetMapping("students/new")
    public String newStudent(Model model){

        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    // Handler method to save new student
    @PostMapping("student/post")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result,Model model){

        if (result.hasErrors()){
            model.addAttribute("student",student);
            return "create_student";
        }

        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("student/{studentid}/edit")
    public String editStudent(@PathVariable("studentid") Long studentid,
                              Model model){
        StudentDto student = studentService.getStudentById(studentid);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("student/{studentid}")
    public String updateStudent(@PathVariable("studentid") Long studentid,
                                @Valid @ModelAttribute("student") StudentDto studentDto,BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("student",studentDto);
            return "edit_student";
        }
        studentDto.setId(studentid);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("student/{studentid}/delete")
    public String deleteStudent(@PathVariable("studentid") Long studentid){
        studentService.deleteStudent(studentid);
        return "redirect:/students";
    }

    @GetMapping("student/{studentid}/view")
    public String viewStudent(@PathVariable("studentid") Long studentid, Model model){
        StudentDto studentDto= studentService.getStudentById(studentid);
        model.addAttribute("student",studentDto);
        return "view_student";
    }
}
