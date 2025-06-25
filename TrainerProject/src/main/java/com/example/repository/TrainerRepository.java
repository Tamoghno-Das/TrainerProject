package com.example.repository;

import com.example.entity.Trainer;

import java.util.List;

public interface TrainerRepository extends org.springframework.data.jpa.repository.JpaRepository<Trainer, Long> {

    List<Trainer> findBySubjectIgnoreCase(String subject);

    List<Trainer> findByEmailEndingWith(String suffix);

    Trainer findFirstByOrderBySalaryDesc();

    List<Trainer> findAllBySubjectIgnoreCase(String subject);


}
