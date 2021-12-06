package com.example.lab3.repo;

import com.example.lab3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.posts.size > 1")
    public List<User> findAllWithPost();

    public Optional<User> findByUsername(String username);
}
