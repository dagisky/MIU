package com.example.lab3.service;

import com.example.lab3.domain.User;
import com.example.lab3.dtos.PostDto;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.helper.ListMapper;
import com.example.lab3.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<User, UserDto> userToUserDtoListMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) userToUserDtoListMapper.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id).orElse(null), UserDto.class);
    }

    @Override
    public UserDto save(UserDto userDto) {
        return modelMapper.map(userRepo.save(modelMapper.map(userDto, User.class)), UserDto.class);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void delete(UserDto userDto) {
        userRepo.delete(modelMapper.map(userDto, User.class));
    }

    @Override
    public UserDto update(long id, UserDto userDto) {
        User u = userRepo.findById(id).orElse(null);
        if(u == null)
            return null;
        u.setName(userDto.getName());
        u.setPosts(userDto.getPosts());
        return modelMapper.map(userRepo.save(u), UserDto.class);
    }

    @Override
    public List<PostDto> findAllWithPost() {
        return (List<PostDto>) userToUserDtoListMapper.mapList(userRepo.findAllWithPost(), new UserDto());
    }
}
