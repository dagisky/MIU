package com.example.lab3.service;

import com.example.lab3.domain.Post;
import com.example.lab3.dtos.PostDto;

import java.util.List;

public interface PostService {
    public PostDto findById(long id);
    public List<PostDto> findAll();
    public PostDto save(PostDto post);
    public void delete(PostDto post);
    public PostDto update(long id, PostDto post);
}
