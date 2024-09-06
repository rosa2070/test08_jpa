package com.example.test08_jpa;

import com.example.test08_jpa.entity.Student;
import com.example.test08_jpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
public class StudentTest {
    @Autowired
    StudentRepository sr;

    @Test
    void save() {
        Student student = sr.save(new Student(0L, "재재", "010"));
        Student student1 = sr.save(new Student(0L, "현재", "010"));
        log.info("student -> {}", student);
    }

    @Test
    void update() {
        Optional<Student> student = sr.findById(1L);
        if (!student.isEmpty()) {
            Student newStudent = student.get();
            newStudent.setName("잰잰");
            newStudent.setPhoneNum("011");
        }
    }

    @Test
    void delete() {
        sr.deleteById(2L);
    }

    @Test
    void selectAll() {
        List<Student> list = sr.findAll();
        list.forEach(s -> log.info("student -> {}", s));
    }

}
