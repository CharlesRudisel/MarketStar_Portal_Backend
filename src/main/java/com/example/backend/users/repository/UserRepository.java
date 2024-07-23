package com.example.backend.users.repository;

import com.example.backend.users.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String username); // Ensure this method returns Optional
}
