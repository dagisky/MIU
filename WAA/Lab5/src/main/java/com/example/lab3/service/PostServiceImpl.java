package com.example.lab3.service;


import com.example.lab3.domain.Post;
import com.example.lab3.dtos.PostDto;
import com.example.lab3.helper.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lab3.repo.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id).orElse(null), PostDto.class);
    }

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public PostDto save(PostDto postDto) {
        return modelMapper.map(postRepo.save(modelMapper.map(postDto, Post.class)), PostDto.class);
    }

    @Override
    public void delete(PostDto post) {
        postRepo.delete(modelMapper.map(post, Post.class));
    }

    @Override
    public PostDto update(long id, PostDto postDto) {
        postDto.setId(id);
        postRepo.save(modelMapper.map(postDto, Post.class));
        return postDto;
    }


}
