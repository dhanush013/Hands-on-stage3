package com.cognizant.LearnTodayRESTAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Trainer;
import com.cognizant.LearnTodayRESTAPI.service.TrainerService;
@RequestMapping("sample-api/")
@RestController
public class TrainerController {

	@Autowired
	TrainerService trainerService;

	@PostMapping("/trainer")
	public ResponseEntity<Object> trainerSignUp(@RequestBody Trainer model) {
		try {
			trainerService.trainerSignUp(model);
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);

		}
	}

	@PutMapping("changePassword/{trainerId}")
	public ResponseEntity<Object> updatePassword(@PathVariable("trainerId") int trainerId,@RequestBody Trainer model){
		try {
		Trainer trainer=trainerService.checkTrainer(trainerId);
		if(trainer==null) {
			return new ResponseEntity<Object>("Searched Data not Found", HttpStatus.NOT_FOUND);
		}
		else {
			trainerService.updatePassword(trainerId, model);
			return new ResponseEntity<Object>("Data updated successfully", HttpStatus.OK);
		}
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
	

}