package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.LecturerRestImpl;
import com.StudentEnrollmentClient.services.LecturerService;

public class LecturerServiceImpl implements LecturerService {
	private RestAPI<Lecturer, Long> rest = new LecturerRestImpl();

	@Override
	public Lecturer findById(Long id) {
		return rest.get(id);
	}

	@Override
	public Lecturer save(Lecturer entity) {
		return rest.post(entity);
	}

	@Override
	public void update(Lecturer entity) {
		// TODO Auto-generated method stub

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
