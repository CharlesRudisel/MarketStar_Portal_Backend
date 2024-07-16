package com.example.backend.assignments;


import com.example.backend.assignments.entity.Assignment;
import com.example.backend.assignments.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentService.getAssignmentById(id);
        return assignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignmentService.saveAssignment(assignment));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Assignment>> createAssignments(@RequestBody List<Assignment> assignments) {
        List<Assignment> createdAssignments = assignmentService.saveAllAssignments(assignments);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment assignmentDetails) {
        Optional<Assignment> assignmentOptional = assignmentService.getAssignmentById(id);

        if (!assignmentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Assignment assignment = assignmentOptional.get();
        assignment.setClientName(assignmentDetails.getClientName());
        assignment.setBlogTopic(assignmentDetails.getBlogTopic());
        assignment.setDueDate(assignmentDetails.getDueDate());
        assignment.setStatus(assignmentDetails.getStatus());
        Assignment updatedAssignment = assignmentService.saveAssignment(assignment);
        return ResponseEntity.ok(updatedAssignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        if (!assignmentService.getAssignmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
