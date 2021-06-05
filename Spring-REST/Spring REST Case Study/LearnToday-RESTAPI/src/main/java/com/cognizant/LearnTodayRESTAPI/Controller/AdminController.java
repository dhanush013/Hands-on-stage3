package com.cognizant.LearnTodayRESTAPI.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.service.CourseService;

@RequestMapping("sample-api/")

@RestController
public class AdminController {
	@Autowired
	CourseService courseService;

@PostMapping(value="courses")
public void addEmployee(@RequestBody Course c) {
	courseService.insertCourse(c);
}

@GetMapping(value="courses")
public ResponseEntity<Object> getAllCourses(){
	List<Course> lst= courseService.getAllCourses();
	if(lst.isEmpty()) {
		return new ResponseEntity<Object>("No Courses",HttpStatus.NOT_FOUND);
	}else {
		return new ResponseEntity<Object>(lst,HttpStatus.OK);
	}
}

@GetMapping(value="course/{id}")
public ResponseEntity<Object> getCourse(@PathVariable("id") int courseId){
	Course e=courseService.getCourseById(courseId);
	if(e==null) {
		return new ResponseEntity<Object>("Searched Data Not Found ",HttpStatus.NOT_FOUND);
	}else {
		return new ResponseEntity<Object>(e,HttpStatus.OK);
	}
}




	
}

