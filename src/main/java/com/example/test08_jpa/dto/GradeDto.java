package com.example.test08_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//    1학기 성적조회(학생번호, 이름, 과목명, 점수)
public class GradeDto {
    private Long studentId;
    private String name;
    private String subject;
    private int score;
}
