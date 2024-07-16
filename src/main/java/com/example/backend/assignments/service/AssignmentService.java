package com.example.backend.assignments.service;

import com.example.backend.assignments.entity.Assignment;
import com.example.backend.assignments.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> saveAllAssignments(List<Assignment> assignments) {
        return assignmentRepository.saveAll(assignments);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
