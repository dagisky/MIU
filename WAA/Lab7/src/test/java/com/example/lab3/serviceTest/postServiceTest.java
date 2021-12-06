package com.example.lab3.serviceTest;

import com.example.lab3.domain.Post;
import com.example.lab3.dtos.PostDto;
import com.example.lab3.helper.ListMapper;
import com.example.lab3.repo.PostRepo;
import com.example.lab3.service.PostService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class postServiceTest {
    private List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post(1, "New Persistance API", "Foo Api is the new kid in the block", "foo"),
            new Post(2, "WAA is given", "The course WAA (Web Application Architecture) is given in MIU", "foo2"),
            new Post(3, "Third News", "This is the third post..", "awesome guy")
    ));

    @MockBean
    private PostRepo postRepo;

    @Autowired
    private PostService postService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Test
    public void findAllTest(){
        when(postService.findAll()).thenReturn((List<PostDto>) listMapperPostToDto.mapList(posts, new PostDto()));
    }
    @Test
    public void findById(){
        when(postService.findById(1)).thenReturn(modelMapper.map(posts.get(1), PostDto.class));
    }

}
