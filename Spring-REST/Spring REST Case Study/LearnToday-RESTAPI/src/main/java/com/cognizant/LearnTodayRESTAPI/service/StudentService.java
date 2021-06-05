package com.cognizant.LearnTodayRESTAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.Repository.CourseRepository;
import com.cognizant.LearnTodayRESTAPI.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository stdRepo;
	@Autowired
	CourseRepository cRepo;
	
	public List<Course> getAllCourses(){
		return cRepo.findAll();
	}
	public void postStudent(Student student) {
		stdRepo.save(student);
	}
	public Student checkStudentEnrollment(int enrollmentId) {
		Optional<Student> studentOptional=stdRepo.findById(enrollmentId);
		if(studentOptional.isPresent())
			return studentOptional.get();
		else
			return null;
	}
	public void deleteStudent(int enrollmentId) {
		stdRepo.deleteById(enrollmentId);
	}
}