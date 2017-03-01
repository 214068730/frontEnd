package com.StudentEnrollmentClient.services;


import java.util.List;

import com.StudentEnrollmentClient.domain.Course;

public interface CourseService extends Services<Course,Long> {
	public  List<Course> getByStudentId(Long id);
 
}
