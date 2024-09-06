package com.example.test08_jpa;

import com.example.test08_jpa.dto.GradeDto;
import com.example.test08_jpa.entity.Grade;
import com.example.test08_jpa.entity.Student;
import com.example.test08_jpa.repository.GradeRepository;
import com.example.test08_jpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class GradeTest {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void save() {
        Optional<Student> optionalStudent = studentRepository.findById(1L);
        if (!optionalStudent.isEmpty()) {
            Student student = optionalStudent.get();
            gradeRepository.save(new Grade(0L, student, "수학", 80, 1));
            gradeRepository.save(new Grade(0L, student, "영어", 70, 2));
            gradeRepository.save(new Grade(0L, student, "체육", 90, 1));
        }
    }

    @Test
    void listAll() {
        List<Grade> list = gradeRepository.findAll();
        list.forEach(grade -> {
            System.out.println("성적번호: " + grade.getId());
            System.out.println("학생번호: " + grade.getStudent().getStudentId());
            System.out.println("과목명: " + grade.getSubject());
            System.out.println("점수: " + grade.getScore());
            System.out.println("학기: " + grade.getSemester());
            System.out.println();
        });
    }

    @Test
    void list1() {
        List<Grade> list = gradeRepository.list1();
        list.forEach(grade -> {
            System.out.println("성적번호: " + grade.getId());
            System.out.println("학생번호: " + grade.getStudent().getStudentId());
            System.out.println("과목명: " + grade.getSubject());
            System.out.println("점수: " + grade.getScore());
            System.out.println("학기: " + grade.getSemester());
            System.out.println();
        });
    }

    @Test
    void select() {
        List<Grade> list = gradeRepository.list2(1L);
        list.forEach(grade -> {
            System.out.println("성적번호: " + grade.getId());
            System.out.println("학생번호: " + grade.getStudent().getStudentId());
            System.out.println("과목명: " + grade.getSubject());
            System.out.println("점수: " + grade.getScore());
            System.out.println("학기: " + grade.getSemester());
            System.out.println();
        });
    }

    @Test
    void list3() {
        List<GradeDto> list = gradeRepository.list3();
        list.forEach(grade -> {
            System.out.println(grade);
        });
    }
}
