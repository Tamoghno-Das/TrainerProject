package com.example.service;

import com.example.entity.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer addTrainer(Trainer trainer);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Long id);
    Trainer updateTrainer(Long id, Trainer trainer);
    void deleteTrainer(Long id);
    List<Trainer> getPythonTrainers();
    List<Trainer> getGmailTrainers();
    Double getTotalSalary();
    Trainer getTopEarner();
    void deleteCppTrainers();
}
