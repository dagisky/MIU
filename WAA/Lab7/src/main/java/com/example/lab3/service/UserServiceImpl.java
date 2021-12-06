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
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j @RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final ListMapper<User, UserDto> userToUserDtoListMapper;



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
        return modelMapper.map(userRepo.findByUsername(username).orElse(null), UserDto.class);
    }

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        log.info("Saving new role {} to the database", roleDto.getName());
        return modelMapper.map(roleRepo.save(modelMapper.map(roleDto, Role.class)), RoleDto.class);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to User {}", roleName, username);
        User user = userRepo.findByUsername(username).orElse(null);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        userRepo.save(user);
    }

    @Override
    public UserDto save(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
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
        u.setPosts(userDto.getPost());
        return modelMapper.map(userRepo.save(u), UserDto.class);
    }

    @Override
    public List<PostDto> findAllWithPost() {
        return (List<PostDto>) userToUserDtoListMapper.mapList(userRepo.findAllWithPost(), new UserDto());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElse(null);
        if(user == null){
            log.error("User not found exception");
            throw new UsernameNotFoundException("User not found exception");
        }
        Collection<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
