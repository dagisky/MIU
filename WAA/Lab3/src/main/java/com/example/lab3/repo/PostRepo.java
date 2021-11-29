package com.example.lab3.repo;

import com.example.lab3.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo  {
    public Post findById(Long id);
    public List<Post> findAll();
    public Post save(Post post);
    public void delete(Post post);
    public Post update(Post post);
}
