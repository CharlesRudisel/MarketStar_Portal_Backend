package com.example.backend.clientbackground.repository;

import com.example.backend.clientbackground.entity.ClientBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBackgroundRepository extends JpaRepository<ClientBackground, Long> {
}
