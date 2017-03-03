package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class ProgressStatusRestImpl implements RestAPI<ProgressStatus, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "enrollment/progress";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public ProgressStatus get(Long id) {
		final String url = BASE_URL + "/" + id;
		ProgressStatus progressStatus = restTemplate.getForObject(url,
				ProgressStatus.class, id.toString());
		return progressStatus;
	}
	
	public ProgressStatus getByStudentStudentIDAndActive(Long studentID,boolean active) {
		final String url = BASE_URL + "/progress/grade/"+studentID+"/"+active;
		ProgressStatus progressStatus = restTemplate.getForObject(url,ProgressStatus.class,studentID.toString(),active);
		return progressStatus;
	}

	@Override
	public ProgressStatus post(ProgressStatus entity) {
		String url = BASE_URL + "/create";
		HttpEntity<ProgressStatus> httpEntity = new HttpEntity<ProgressStatus>(
				entity, requestHeaders);
		ProgressStatus progressStatus = restTemplate.postForObject(url,
				httpEntity, ProgressStatus.class);
		return progressStatus;
	}

	@Override
	public void put(ProgressStatus entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProgressStatus entity) {
		String id =  entity.getId()+"";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);

	}

	@Override
	public List<ProgressStatus> getAll() {
		String url = BASE_URL + "/findAll";
		List<ProgressStatus> progressList = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<ProgressStatus[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, ProgressStatus[].class);
		ProgressStatus[] results = responseEntity.getBody();

		for (ProgressStatus b : results) {
			progressList.add(b);
		}
		return progressList;
	}

}
