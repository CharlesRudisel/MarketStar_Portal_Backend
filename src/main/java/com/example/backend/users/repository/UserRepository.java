package com.example.backend.users.repository;

import com.example.backend.users.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
}
