package com.example.test08_jpa;

import com.example.test08_jpa.dto.BoardDto;
import com.example.test08_jpa.entity.Board;
import com.example.test08_jpa.entity.Myuser;
import com.example.test08_jpa.repository.BoardRepository;
import com.example.test08_jpa.repository.MyuserRepository;
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
public class BoardTest {
    @Autowired
    BoardRepository br;
    @Autowired
    MyuserRepository mr;

    @Test
    void save() {
        Optional<Myuser> mu = mr.findById("user2");
        if (!mu.isEmpty()) {
            Myuser myuser = mu.get();
            br.save(new Board(0L, myuser, "test...", "byebye!!", null));
            br.save(new Board(0L, myuser, "hello!...", "11!!", null));
            br.save(new Board(0L, myuser, "hihi!!...", "111!!", null));
        }
    }

    @Test
    void listAll() {
        List<Board> list = br.findAll();
        list.forEach(board -> {
            System.out.println("글번호: " + board.getNum());
//            System.out.println("작성자: " + board.getUser().getUsername());
            System.out.println("제목: " + board.getTitle());
            System.out.println("내용: " + board.getContent());
            System.out.println("작성일: " + board.getRegDate());
            System.out.println();
        });
    }

    @Test
    void list1() {
        List<Board> list = br.list1();
        list.forEach(board -> {
            System.out.println("글번호: " + board.getNum());
            System.out.println("작성자: " + board.getUser().getUsername());
            System.out.println("제목: " + board.getTitle());
            System.out.println("내용: " + board.getContent());
            System.out.println("작성일: " + board.getRegDate());
            System.out.println();
        });
    }

    @Test
    void select() {
        List<Board> list = br.list2("user2");
        list.forEach(board -> {
            System.out.println("글번호: " + board.getNum());
            System.out.println("작성자: " + board.getUser().getUsername());
            System.out.println("제목: " + board.getTitle());
            System.out.println("내용: " + board.getContent());
            System.out.println("작성일: " + board.getRegDate());
            System.out.println();
        });
    }

    @Test
    void list3() {
        List<BoardDto> list = br.list3();
        list.forEach(board -> {
            System.out.println(board);
        });
    }


}
