package com.springmvc.repositry;

import com.springmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositry extends JpaRepository<Student,Long> {
}
