package com.cognizant.LearnTodayRESTAPI.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.LearnTodayRESTAPI.model.Trainer;
import com.cognizant.LearnTodayRESTAPI.Repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	TrainerRepository trainerRepo;

	public void trainerSignUp(Trainer Model) {
		trainerRepo.save(Model);
	}

	public Trainer checkTrainer(int trainerId) {
		Optional<Trainer> trainerOptional=trainerRepo.findById(trainerId);
		if(trainerOptional.isPresent())
			return trainerOptional.get();
		else
			return null;
	}
	
	public void updatePassword(int trainerId,Trainer Model) {
		Trainer t=trainerRepo.findById(trainerId).get();
		t.setPassword(Model.getPassword());
		trainerRepo.save(t);
	}

}