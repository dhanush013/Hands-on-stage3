package com.cognizant.LearnTodayRESTAPI.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.LearnTodayRESTAPI.Repository.CourseRepository;
import com.cognizant.LearnTodayRESTAPI.model.Course;




@Service
public class CourseService {
	@Autowired
	CourseRepository repo;
	public void insertCourse(Course c) {
		repo.save(c);
	}
	public List<Course> getAllCourses(){
		return repo.findAll();
	}
	public Course getCourseById(int courseId) {
		Optional<Course> op=repo.findById(courseId);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
}
