package com.example.lab3.service;

import com.example.lab3.domain.Role;
import com.example.lab3.domain.User;
import com.example.lab3.dtos.PostDto;
import com.example.lab3.dtos.RoleDto;
import com.example.lab3.dtos.UserDto;
import com.example.lab3.helper.ListMapper;
import com.example.lab3.repo.RoleRepo;
import com.example.lab3.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<User, UserDto> userToUserDtoListMapper;


    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) userToUserDtoListMapper.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto findById(long id) {
        return modelMapper.map(userRepo.findById(id).orElse(null), UserDto.class);
    }

    @Override
    public UserDto findByUsername(String username) {
        return modelMapper.map(userRepo.findByUsername(username), UserDto.class);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepo.save(user), UserDto.class);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        return modelMapper.map(roleRepo.save(modelMapper.map(roleDto, Role.class)), RoleDto.class);

    }

    @Override
    public void addRoleToUser(String  username, String roleName) {
        User user = userRepo.findByUsername(username).orElse(null);
        Role role =  roleRepo.findByName(roleName).orElse(null);
        if(user != null && role != null){
            RoleDto roleDto = modelMapper.map(role, RoleDto.class);
            List<Role> rols = user.getRoles();
            rols.add(modelMapper.map(roleDto, Role.class));
            user.setRoles(rols);
            userRepo.save(user);
        }
    }

    @Override
    public void deleteRole(RoleDto roleDto) {
        roleRepo.delete(modelMapper.map(roleDto, Role.class));
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
