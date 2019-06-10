package com.fortech.internship.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.model.Address;
import com.fortech.internship.service.impl.mapper.ToDTO;
import com.fortech.internship.service.impl.mapper.ToEntity;

@Service
public class AddressService {

	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false)
	public void createAddress(AddressDTO addressDTO) {
		// addressDAO.createAddress(address);
		// Session session = sessionFactory.getCurrentSession();
		// Address address = new Address();
		// address.setId(addressDTO.getId());
		// address.setPostalCode(addressDTO.getPostalCode());
		// session.save(address);
		addressDAO.createAddress(ToEntity.address(addressDTO));
	}

	@Transactional(readOnly = true)
	public Address getAddressById(int id) {
		Address address = addressDAO.getAddressById(id);
		return address;
	}

	@Transactional(readOnly = true)
	public List<AddressDTO> getAllAddresses() {
		List<Address> addresses = addressDAO.getAllAddresses();
		List<AddressDTO> addressesDTOs = new ArrayList<>();
		for (Address address : addresses) {
			addressesDTOs.add(ToDTO.address(address));
		}
		return addressesDTOs;
	}

	@Transactional(readOnly = false)
	public boolean updateAddress(AddressDTO addressDTO) {
		Address address = null;
		if (addressDTO.getId() != 0) {
			address = addressDAO.getAddressById(addressDTO.getId());
		} else {
			address = (Address) addressDAO.getAddressByPostalCode(addressDTO
					.getPostalCode());
		}

		if (address != null) {

			address.setPostalCode(addressDTO.getPostalCode());

		}
		return addressDAO.updateAddress(address);
	}

	@Transactional(readOnly = false)
	public void deleteAddress(int id) {
		addressDAO.deleteAddress(id);
	}
}