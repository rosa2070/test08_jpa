package com.example.test08_jpa;

import com.example.test08_jpa.entity.Myuser;
import com.example.test08_jpa.repository.MyuserRepository;
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
public class MyuserTest {
    @Autowired
    MyuserRepository mu;

    @Test
    void save() {
        Myuser user = mu.save(new Myuser("user2", "0000", "user2@", null, null));
        log.info("user -> {}", user);
    }

    //user2의 정보를 수정해 보세요(비밀번호, 이메일)
    @Test
    void update() {
        Optional<Myuser> m = mu.findById("user2");
        if (!m.isEmpty()) {
            Myuser mu = m.get();
            mu.setEmail("aaa");
            mu.setPassword("2222");
        }
    }

    //삭제 / 전체 조회도 테스트 해보세요
    @Test
    void delete() {
        mu.deleteById("user2");
    }

    @Test
    void selectAll() {
        List<Myuser> list = mu.findAll();
        list.forEach(u -> log.info("user -> {}", u));
    }

}
