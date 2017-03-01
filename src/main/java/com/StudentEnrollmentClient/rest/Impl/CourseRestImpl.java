package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Course;
import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class CourseRestImpl implements RestAPI<Course, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "/course";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public Course get(Long id) {
		final String url = BASE_URL + "/" + id;
		Course course = restTemplate.getForObject(url, Course.class,
				id.toString());
		return course;
	}

	@Override
	public Course post(Course entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Course> httpEntity = new HttpEntity<>(entity, requestHeaders);
		Course course = restTemplate.postForObject(url, httpEntity,
				Course.class);
		return course;
	}

	@Override
	public void put(Course entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course entity) {
		String id = entity.getId().toString();
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url, id);

	}

	@Override
	public List<Course> getAll() {
		String url = BASE_URL + "/findAll";
		List<Course> courses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Course[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Course[].class);
		Course[] results = responseEntity.getBody();

		for (Course b : results) {
			courses.add(b);
		}
		return courses;
	}

	public List<Course> getByStudentId(Long id) {
		String url = BASE_URL + "/findAll/" + id;
		List<Course> courseList = new ArrayList<Course>();
		List<Course> courses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Course[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Course[].class);
		Course[] results = responseEntity.getBody();
		for (Course b : results) {
			courses.add(b);
		}
		return courses;
	}

}
