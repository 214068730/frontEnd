package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.SubjectCourse;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.SubjectCourseRestImpl;
import com.StudentEnrollmentClient.rest.Impl.SubjectRestImpl;
import com.StudentEnrollmentClient.services.SubjectCourseService;

public class SubjectCourseServiceImpl implements SubjectCourseService {
	private RestAPI<SubjectCourse, Long> rest = new SubjectCourseRestImpl();

	@Override
	public SubjectCourse findById(Long id) {
		return rest.get(id);
	}

	@Override
	public SubjectCourse save(SubjectCourse entity) {
		return rest.post(entity);
	}

	@Override
	public void update(SubjectCourse entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(SubjectCourse entity) {
		rest.delete(entity);

	}

	@Override
	public List<SubjectCourse> findAll() {
		return rest.getAll();
	}

}
