package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.domain.SubjectCourse;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class SubjectCourseRestImpl implements RestAPI<SubjectCourse, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "/subjectCourse";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public SubjectCourse get(Long id) {
		final String url = BASE_URL + "/" + id;
		SubjectCourse subjectCourse = restTemplate.getForObject(url,
				SubjectCourse.class, id.toString());
		return subjectCourse;
	}

	@Override
	public SubjectCourse post(SubjectCourse entity) {
		String url = BASE_URL + "/create";
		HttpEntity<SubjectCourse> httpEntity = new HttpEntity<SubjectCourse>(
				entity, requestHeaders);
		SubjectCourse subjectCourse = restTemplate.postForObject(url,
				httpEntity, SubjectCourse.class);
		return subjectCourse;
	}

	@Override
	public void put(SubjectCourse entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(SubjectCourse entity) {
		String id = entity.getId() + "";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url, id);

	}

	@Override
	public List<SubjectCourse> getAll() {
		String url = BASE_URL + "/findAll";
		List<SubjectCourse> subjectCourses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<SubjectCourse[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, SubjectCourse[].class);
		SubjectCourse[] results = responseEntity.getBody();

		for (SubjectCourse b : results) {
			subjectCourses.add(b);
		}
		return subjectCourses;
	}

}
