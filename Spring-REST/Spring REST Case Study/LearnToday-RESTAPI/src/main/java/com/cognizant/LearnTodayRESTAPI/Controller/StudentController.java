package com.cognizant.LearnTodayRESTAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.service.StudentService;
@RequestMapping("sample-api/")
@RestController
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@GetMapping("/student/courses")
	public ResponseEntity<Object> getAllCourses() {

		List<Course> courseList = studentService.getAllCourses();
		if (courseList.isEmpty())
			return new ResponseEntity<Object>("No Courses", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(courseList, HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Object> postStudent(@RequestBody Student model) {
		try {
			studentService.postStudent(model);
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/student/{enrollmentId}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable("enrollmentId") int enrollmentId){
		try {
			Student student=studentService.checkStudentEnrollment(enrollmentId);
			if(student==null) {
				return new ResponseEntity<Object>("No enrollement information found",HttpStatus.NOT_FOUND);
			}
			else
			{
				studentService.deleteStudent(enrollmentId);
				return new ResponseEntity<Object>("Student enrollment deleted", HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}	
	}
	
	

}