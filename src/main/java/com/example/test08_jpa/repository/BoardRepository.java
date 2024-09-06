package com.example.test08_jpa.repository;

import com.example.test08_jpa.dto.BoardDto;
import com.example.test08_jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board b join b.user u")
    List<Board> list1();

    @Query("select b from Board b join b.user u where u.username=:username") //:옆에 파라미터
    List<Board> list2(@Param("username") String username);

    @Query("select new com.example.test08_jpa.dto.BoardDto(b.num, u.username, b.title, b.content) "
            + "from Board b join b.user u")
    List<BoardDto> list3();
}
