package com.example.test08_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private Long num;
    private String username;
    private String title;
    private String content;
}
