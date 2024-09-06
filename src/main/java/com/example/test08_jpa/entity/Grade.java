package com.example.test08_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 학생테이블을 참조하는 성적테이블을 만들고 데이터 저장후 학생 성적 조회하기
//     성적테이블(성적번호, 학생번호, 과목명, 점수, 학기)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="studentId")
    private Student student;
    private String subject;
    private int score;
    private int semester;

}
