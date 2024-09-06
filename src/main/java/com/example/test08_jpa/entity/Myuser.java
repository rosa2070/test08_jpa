package com.example.test08_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myuser")
@EntityListeners(AuditingEntityListener.class)
public class Myuser {
    @Id
    private String username;
    private String password;
    private String email;
    @CreatedDate // 생성날짜 자동생성
    private LocalDateTime createdDate;
    @LastModifiedDate //업데이트할때마다
    private LocalDateTime updatedDate;
}
