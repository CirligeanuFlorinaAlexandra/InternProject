package com.fortech.internship.dao;

import java.util.List;

import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.model.Address;
import com.fortech.internship.model.User;


public interface AddressDAO {
	
	public void createAddress(Address address);
	
	public Address getAddressById(int id);
	
	public Address getAddressByPostalCode(String postalCode);
	
	public List<Address> getAllAddresses();
	
	public boolean updateAddress(Address address);
	
	public void deleteAddress(int id);


}