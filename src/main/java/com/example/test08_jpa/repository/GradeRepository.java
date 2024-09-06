package com.example.test08_jpa.repository;


import com.example.test08_jpa.dto.GradeDto;
import com.example.test08_jpa.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("select g from Grade g join g.student s")
    List<Grade> list1();

    @Query("select g from Grade g join g.student s where s.studentId=:studentId")
    List<Grade> list2(@Param("studentId") Long studentId);

    @Query("select new com.example.test08_jpa.dto.GradeDto(s.studentId, s.name, g.subject, g.score)"
            + "from Grade g join g.student s")
    List<GradeDto> list3();


}
