package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Address;
import com.StudentEnrollmentClient.domain.StudentCourse;
import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class StudentCourseRestImpl implements RestAPI<StudentCourse, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "enrollment/course";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public StudentCourse get(Long id) {
		final String url = BASE_URL + "/" + id;
		StudentCourse course = restTemplate.getForObject(url, StudentCourse.class,
				id.toString());
		return course;
	}

	@Override
	public StudentCourse post(StudentCourse entity) {
		String url = BASE_URL + "/create";
		HttpEntity<StudentCourse> httpEntity = new HttpEntity<>(entity, requestHeaders);
		StudentCourse course = restTemplate.postForObject(url, httpEntity,
				StudentCourse.class);
		return course;
	}

	@Override
	public StudentCourse put(StudentCourse entity) {
		String url = BASE_URL + "/update";
		HttpEntity<StudentCourse> requestEntity = new HttpEntity<StudentCourse>(entity,requestHeaders);
		ResponseEntity<StudentCourse> responseEntity = restTemplate.exchange(url,HttpMethod.PUT, requestEntity, StudentCourse.class);
		StudentCourse studentCourse = responseEntity.getBody();
		return studentCourse;
	}

	@Override
	public void delete(StudentCourse entity) {
		String id = entity.getId().toString();
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url, id);

	}

	@Override
	public List<StudentCourse> getAll() {
		String url = BASE_URL + "/findAll";
		List<StudentCourse> courses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<StudentCourse[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, StudentCourse[].class);
		StudentCourse[] results = responseEntity.getBody();

		for (StudentCourse b : results) {
			courses.add(b);
		}
		return courses;
	}

	public List<StudentCourse> getByStudentId(Long id) {
		String url = BASE_URL + "/findAll/" + id;
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		List<StudentCourse> courses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<StudentCourse[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, StudentCourse[].class);
		StudentCourse[] results = responseEntity.getBody();
		for (StudentCourse b : results) {
			courses.add(b);
		}
		return courses;
	}

	public List<StudentCourse> findByCourseCourseIDAndStudentStudentID(Long courseID,Long studentID){
		String url = BASE_URL + "/studentCourse/findStudentRecord/"+courseID+"/"+studentID;
		List<StudentCourse> courseList = new ArrayList<StudentCourse>();
		List<StudentCourse> courses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<StudentCourse[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, StudentCourse[].class);
		StudentCourse[] results = responseEntity.getBody();
		for (StudentCourse b : results) {
			courses.add(b);
		}
		return courses;
	}
}
