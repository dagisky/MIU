package com.example.lab3.controller;

import com.example.lab3.dtos.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.lab3.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "X-API-VERSION=1")
    public EntityModel<PostDto> findPostV1(@PathVariable("id") long id){
        PostDto post = postService.findById(id);
        EntityModel<PostDto> postEntityModel = EntityModel.of(post);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        postEntityModel.add(linkBuilder.withRel("allPosts"));
        return postEntityModel;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "X-API-VERSION=2")
    public EntityModel<PostDto> findPostV2(@PathVariable("id") long id){
        PostDto post = postService.findById(id);
        EntityModel<PostDto> postEntityModel = EntityModel.of(post);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        postEntityModel.add(linkBuilder.withRel("allPosts"));
        return postEntityModel;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public EntityModel<PostDto> createPost(@RequestBody PostDto post){
        PostDto p = postService.save(post);
        EntityModel<PostDto> entityModel = EntityModel.of(p);
        WebMvcLinkBuilder findPostLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findPostV1(p.getId()));
        WebMvcLinkBuilder findAllLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        entityModel.add(findPostLink.withRel("findPost"));
        entityModel.add(findAllLink.withRel("findAllPost"));
        return entityModel;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") long id){
        PostDto post = postService.findById(id);
        postService.delete(post);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = "application/json")
    public EntityModel<PostDto> updatePost(@PathVariable("id") long id, @RequestBody PostDto post){
        PostDto p = postService.update(id, post);
        EntityModel<PostDto> entityModel = EntityModel.of(p);
        WebMvcLinkBuilder findAllLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        entityModel.add(findAllLink.withRel("findAll"));
        return entityModel;
    }



}
