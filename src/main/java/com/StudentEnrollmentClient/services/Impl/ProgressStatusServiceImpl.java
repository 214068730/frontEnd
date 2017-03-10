package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.rest.Impl.ProgressStatusRestImpl;
import com.StudentEnrollmentClient.services.ProgressStatusService;

public class ProgressStatusServiceImpl implements ProgressStatusService {

	private ProgressStatusRestImpl rest = new ProgressStatusRestImpl();

	@Override
	public ProgressStatus findById(Long id) {
		return rest.get(id);
	}

	@Override
	public ProgressStatus save(ProgressStatus entity) {
		return rest.post(entity);
	}

	@Override
	public ProgressStatus update(ProgressStatus entity) {
		return rest.put(entity);
	}

	@Override
	public void delete(ProgressStatus entity) {
		rest.delete(entity);

	}

	@Override
	public List<ProgressStatus> findAll() {
		return rest.getAll();
	}

	@Override
	public ProgressStatus findByStudentStudentIDAndActive(Long studentID,int activated,Long courseID) {
		return rest.getByStudentStudentIDAndActive(studentID, activated, courseID);
	}

	@Override
	public ProgressStatus getActive(Long studentID, int active) {
		return rest.getActive(studentID, active);
	}

}
