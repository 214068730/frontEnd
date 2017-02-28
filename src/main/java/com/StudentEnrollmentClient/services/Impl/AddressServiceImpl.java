package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Address;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.AddressRestImpl;
import com.StudentEnrollmentClient.services.AddressService;

public class AddressServiceImpl implements AddressService{
	private RestAPI<Address, Long> rest = new AddressRestImpl();

	@Override
	public Address findById(Long id) {
		return rest.get(id);
	}

	@Override
	public Address save(Address entity) {
		return rest.post(entity);
	}

	@Override
	public void update(Address entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Address entity) {
		rest.delete(entity);;
		
	}

	@Override
	public List<Address> findAll() {
		return rest.getAll();
	}
	

}
