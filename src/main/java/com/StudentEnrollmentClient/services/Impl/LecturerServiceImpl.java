package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.LecturerRestImpl;
import com.StudentEnrollmentClient.services.LecturerService;

public class LecturerServiceImpl implements LecturerService {
	private LecturerRestImpl rest = new LecturerRestImpl();

	@Override
	public Lecturer findById(Long id) {
		return rest.get(id);
	}
	
	public Lecturer findByNameAndSurname(String name,String surname) {
		return rest.getByNameAndSurname(name, surname);
	}

	@Override
	public Lecturer save(Lecturer entity) {
		return rest.post(entity);
	}

	@Override
	public Lecturer update(Lecturer entity) {
		return rest.put(entity);
	}

	@Override
	public void delete(Lecturer entity) {
		rest.delete(entity);

	}

	@Override
	public List<Lecturer> findAll() {
		return rest.getAll();
	}
	
	

}
