package com.StudentEnrollmentClient.services;

import java.util.List;

import com.StudentEnrollmentClient.domain.Subject;

public interface SubjectService extends Services<Subject,Long> {
	public Subject getSubjectCode(String subjectCode);
	public List<Subject> getAllBySubjectLevel(Long courseID,Long studentID);

}
