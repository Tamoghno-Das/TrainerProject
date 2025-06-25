package com.example.controller;

import com.example.entity.Trainer;
import com.example.service.TrainerService;
import jakarta.validation.Valid;  // Import for validation annotations
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService service;

    @PostMapping
    public Trainer addTrainer(@RequestBody @Valid Trainer trainer) {
        return service.addTrainer(trainer);// Validate the trainer object before adding it
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return service.getAllTrainers();// Retrieve all trainers from the service
    }

    @GetMapping("/{id}")
    public Trainer getTrainerById(@PathVariable Long id) {
        return service.getTrainerById(id);// Retrieve a trainer by ID from the service
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable Long id, @RequestBody @Valid Trainer trainer) {
        return service.updateTrainer(id, trainer);// Update a trainer by ID with the provided trainer object
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteTrainer(@PathVariable Long id) {
        service.deleteTrainer(id);
        return Map.of("message", "Trainer deleted with ID: " + id);// Delete a trainer by ID and return a confirmation message
    }

    @GetMapping("/python")
    public List<Trainer> getPythonTrainers() {
        return service.getPythonTrainers();// Retrieve trainers who teach Python
    }

    @GetMapping("/gmail")
    public List<Trainer> getGmailTrainers() {
        return service.getGmailTrainers();
    }// Retrieve trainers with Gmail addresses

    @GetMapping("/total-salary")
    public Double getTotalSalary() {
        return service.getTotalSalary();
    }// Calculate the total salary of all trainers

    @GetMapping("/top-earner")
    public Trainer getTopEarner() {
        return service.getTopEarner();
    }// Retrieve the trainer with the highest salary

    @DeleteMapping("/cpp")
    public Map<String, String> deleteCppTrainers() {
        service.deleteCppTrainers();
        return Map.of("message", "All C++ trainers deleted.");
    }// Delete all trainers who teach C++
}