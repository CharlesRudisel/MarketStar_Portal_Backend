package com.example.backend.writesuccess.repository;

import com.example.backend.writesuccess.entity.WriterSuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterSuccessRepository extends JpaRepository<WriterSuccess, Long> {
}

