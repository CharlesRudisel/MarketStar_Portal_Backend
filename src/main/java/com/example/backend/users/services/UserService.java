package com.example.backend.users.services;

import com.example.backend.users.entity.UserInfo;
import com.example.backend.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfo saveUser(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserInfo> saveAllUsers(List<UserInfo> users) {
        return userRepository.saveAll(users);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserInfo> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
