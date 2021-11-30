package com.example.lab3.repo;

import com.example.lab3.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    private List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post(1, "New Persistance API", "Foo Api is the new kid in the block", "foo"),
            new Post(2, "WAA is given", "The course WAA (Web Application Architecture) is given in MIU", "foo2"),
            new Post(3, "Third News", "This is the third post..", "awesome guy")
    ));


    @Override
    public Post findById(Long id) {
        Post post = null;
        for(Post p: this.posts)
            if(p.getId() == id)
                post = p;
        return post;
    }

    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public Post save(Post post) {
        this.posts.add(post);
        return post;
    }

    @Override
    public void delete(Post post) {
        for(Post p: this.posts){
            if(p.getId() == post.getId()){
                this.posts.remove(p);
            }
        }
    }

    @Override
    public Post update(long id, Post post) {
        Post p = posts.stream().filter(ps-> ps.getId() == id).findFirst().orElse(null);
        posts.set(posts.indexOf(p), post);

        return p;
    }


}
