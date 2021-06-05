package com.cognizant.LearnTodayRESTAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
  private int enrollmentId;
  private int studentId;
  private int courseId;
  Student(){
	  
  }
public int getEnrollmentId() {
	return enrollmentId;
}
public void setEnrollmentId(int enrollmentId) {
	this.enrollmentId = enrollmentId;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
  
}
