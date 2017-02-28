package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.StudentRestImpl;
import com.StudentEnrollmentClient.services.StudentService;

public class StudentServiceImpl implements StudentService {

	private RestAPI<Student, Long> rest = new StudentRestImpl();

	@Override
	public Student findById(Long id) {
		return rest.get(id);
	}

	@Override
	public Student save(Student entity) {
		return rest.post(entity);
	}

	@Override
	public void update(Student entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Student entity) {
		rest.delete(entity);

	}

	@Override
	public List<Student> findAll() {
		return rest.getAll();
	}
	
	//extra methods here

}
