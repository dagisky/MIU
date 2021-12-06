package com.example.lab3.repo;

import com.example.lab3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.posts.size > 1")
    public List<User> findAllWithPost();

    public Optional<User> findByUsername(String username);
}
