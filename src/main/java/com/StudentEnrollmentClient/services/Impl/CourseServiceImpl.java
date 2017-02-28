package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.CourseRestImpl;
import com.StudentEnrollmentClient.services.CourseService;

public class CourseServiceImpl implements CourseService{

	private RestAPI<Course, Long> rest = new CourseRestImpl();

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course save(Course entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Course entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Course entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
