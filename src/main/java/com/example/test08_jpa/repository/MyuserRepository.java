package com.example.test08_jpa.repository;

import com.example.test08_jpa.entity.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;

//<>첫번째매개변수 : 엔티티객체
// <> 두번째 매개변수 : primary key 자료형
public interface MyuserRepository extends JpaRepository<Myuser,String> {

}
