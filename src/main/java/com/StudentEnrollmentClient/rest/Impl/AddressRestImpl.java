package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Address;
import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;



public class AddressRestImpl implements RestAPI<Address, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "enrollment/address";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public Address get(Long id) {
		final String url = BASE_URL + "/" + id;
		Address address = restTemplate.getForObject(url, Address.class,id.toString());
		return address;
	}

	@Override
	public Address post(Address entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Address> httpEntity = new HttpEntity<Address>(entity,requestHeaders);
		Address address = restTemplate.postForObject(url, httpEntity,Address.class);
		return address;
	}

	@Override
	public Address put(Address entity) {
		String url = BASE_URL + "/update";
		HttpEntity<Address> requestEntity = new HttpEntity<Address>(entity,requestHeaders);
		ResponseEntity<Address> responseEntity = restTemplate.exchange(url,HttpMethod.PUT, requestEntity, Address.class);
		Address address = responseEntity.getBody();
		return address;
	}

	@Override
	public void delete(Address entity) {
		String id =  entity.getAddressID()+"";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);
	}

	@Override
	public List<Address> getAll() {
		String url = BASE_URL + "/findAll";
		List<Address> addresses = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Address[]> responseEntity = restTemplate.exchange(url,HttpMethod.GET, requestEntity, Address[].class);
		Address[] results = responseEntity.getBody();

		for (Address b : results) {
			addresses.add(b);
		}
		return addresses;
	}

}
