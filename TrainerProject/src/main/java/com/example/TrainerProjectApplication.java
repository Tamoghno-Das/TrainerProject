package com.example;

import com.example.entity.Trainer;
import com.example.repository.TrainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainerProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrainerProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(TrainerRepository repo) {
		return args -> {
			repo.save(new Trainer("Tom", "9845600521", "Kolkata", "tom5@gmail.com", "Python", 60000));
			repo.save(new Trainer("Aditya", "67378589809", "Delhi", "adit@yahoo.com", "C++", 50000));
			repo.save(new Trainer("John", "7543219099", "Mumbai", "john5@gmail.com", "Java", 70000));
			repo.save(new Trainer("Albert", "9099876599", "Bangalore", "albert@gmail.com", "Python", 80000));
			repo.save(new Trainer("Nicholas", "8903456121", "Chennai", "nicholas@gmail.com", "C++", 40000));
			repo.save(new Trainer("Frank", "7009347813", "Pune", "frank3@outlook.com", "Java", 65000));
			repo.save(new Trainer("Sherlock", "6234448901", "Hyderabad", "sherlock34@gmail.com", "Python", 72000));
			repo.save(new Trainer("Henry", "7896432214", "Jaipur", "henry45@gmail.com", "JavaScript", 55000));
			repo.save(new Trainer("Amal", "9876553421", "Goa", "amal22@yahoo.com", "Python", 78000));
			repo.save(new Trainer("Jack", "7439445815", "Ahmedabad", "jack3@gmail.com", "C++", 62000));
		};
	}
}