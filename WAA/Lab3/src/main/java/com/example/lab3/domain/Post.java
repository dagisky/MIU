package com.example.lab3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    long id;
    String title;
    String content;
    String author;
}
