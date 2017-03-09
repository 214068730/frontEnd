package com.StudentEnrollmentClient.services;

import com.StudentEnrollmentClient.domain.Course;


public interface CourseService extends Services<Course,Long>{
	public Course getByName(String name);

}
