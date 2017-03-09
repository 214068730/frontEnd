package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.rest.Impl.CourseRestImpl;
import com.StudentEnrollmentClient.services.CourseService;

public class CourseServiceImpl implements CourseService{

	private CourseRestImpl rest = new CourseRestImpl();
	
	@Override
	public Course findById(Long id) {
		return rest.get(id);
	}

	@Override
	public Course save(Course entity) {
		return rest.post(entity);
	}

	@Override
	public Course update(Course entity) {
		return rest.put(entity);
	}

	@Override
	public void delete(Course entity) {
		rest.delete(entity);
		
	}

	@Override
	public List<Course> findAll() {
		return rest.getAll();
	}

	@Override
	public Course getByName(String name) {
		return rest.getByName(name);
	}

}
