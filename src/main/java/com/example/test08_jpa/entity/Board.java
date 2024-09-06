package com.example.test08_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

/*
    FetchType : JPA가 하나의 Entity를 조회할 때, 연관관계에 있는 객체들을 어떻게 가져올 것이냐를 나타내는 설정값
    @xxToxx(fetch = fetchType.EAGER) : 즉시로딩 ==> 데이터를 조회할 때, 연관된 모든 객체의 데이터까지 한 번에 불러옴
    @xxToxx(fetch = fetchType.LAZY) : 지연로딩 ==> 필요한 시점에 연관된 객체의 데이터를 불러옴
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment같은
    private Long num;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private Myuser user;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private Date regDate;
}
