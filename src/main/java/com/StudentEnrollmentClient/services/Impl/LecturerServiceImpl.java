package com.StudentEnrollmentClient.services.Impl;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.LecturerRestImpl;

public class LecturerServiceImpl {
	private RestAPI<Lecturer, Long> rest = new LecturerRestImpl();

}
