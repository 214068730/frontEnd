package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.SubjectRestImpl;
import com.StudentEnrollmentClient.services.SubjectService;

public class SubjectServiceImpl implements SubjectService {
	private RestAPI<Subject, Long> rest = new SubjectRestImpl();

	@Override
	public Subject findById(Long id) {
		return rest.get(id);
	}

	@Override
	public Subject save(Subject entity) {
		return rest.post(entity);
	}

	@Override
	public Subject update(Subject entity) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public void delete(Subject entity) {
		rest.delete(entity);
		
	}

	@Override
	public List<Subject> findAll() {
		return rest.getAll();
	}

}
