package com.example.service.impl;

import com.example.entity.Trainer;
import com.example.repository.TrainerRepository;
import com.example.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository repo;// Repository for Trainer entity

    @Override
    public Trainer addTrainer(Trainer trainer) {
        return repo.save(trainer); // Save a new trainer to the repository
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return repo.findAll();// Retrieve all trainers from the repository
    }

    @Override
    public Trainer getTrainerById(Long id) {
        return repo.findById(id).orElse(null);
    }// Retrieve a trainer by ID, returning null if not found

    @Override
    public Trainer updateTrainer(Long id, Trainer trainer) {
        Optional<Trainer> existing = repo.findById(id);

        if (existing.isPresent()) {
            Trainer t = existing.get();
            t.setName(trainer.getName());
            t.setPhone(trainer.getPhone());
            t.setAddress(trainer.getAddress());
            t.setEmail(trainer.getEmail());
            t.setSubject(trainer.getSubject());
            t.setSalary(trainer.getSalary());
            return repo.save(t);// Update the existing trainer with new details and save it
        } else {
            throw new RuntimeException("Trainer with ID " + id + " not found.");
        }
    }// Update a trainer by ID with the provided trainer object, throwing an exception if not found

    @Override
    public void deleteTrainer(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Trainer with ID " + id + " does not exist.");
        }// Delete a trainer by ID, throwing an exception if the trainer does not exist
    }

    @Override
    public List<Trainer> getPythonTrainers() {
        return repo.findBySubjectIgnoreCase("Python");
    }// Retrieve trainers who teach Python, ignoring case

    @Override
    public List<Trainer> getGmailTrainers() {
        return repo.findByEmailEndingWith("@gmail.com");
    }// Retrieve trainers with Gmail addresses

    @Override
    public Double getTotalSalary() {
        return repo.findAll().stream()
                .mapToDouble(Trainer::getSalary)
                .sum();
    }// Calculate the total salary of all trainers by summing their salaries

    @Override
    public Trainer getTopEarner() {
        return repo.findFirstByOrderBySalaryDesc();
    }// Retrieve the trainer with the highest salary

    @Override
    public void deleteCppTrainers() {
        List<Trainer> cppTrainers = repo.findAllBySubjectIgnoreCase("C++");
        repo.deleteAll(cppTrainers);
    }// Delete all trainers who teach C++, ignoring case
}