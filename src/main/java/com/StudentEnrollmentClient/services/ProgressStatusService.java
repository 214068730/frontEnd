package com.StudentEnrollmentClient.services;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.ProgressStatus;

public interface ProgressStatusService extends Services<ProgressStatus, Long> {
	public ProgressStatus findByStudentStudentIDAndActive(Long studentID,String activated,Long courseID);
	public ProgressStatus getActive(Long studentID, String active);

}
