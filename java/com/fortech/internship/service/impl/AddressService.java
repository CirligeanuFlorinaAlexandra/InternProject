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


@Service

public class AddressService {
	
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void createAddress(AddressDTO addressDTO) {
		//addressDAO.createAddress(addressDTO);
		Session session = sessionFactory.getCurrentSession();
		Address address = new Address();
		address.setId(addressDTO.getId());
		address.setPostalCode(addressDTO.getPostalCode());
		session.save(address);
	}

	@Transactional
	public Address getAddressById(int id) {
		Address address = addressDAO.getAddressById(id);
		return address;
	}

	@Transactional
	public List<AddressDTO> getAllAddresses() {
		List<Address> addresses = addressDAO.getAllAddresses();
		List<AddressDTO> addressesDTO = new ArrayList<>();
		for (Address address : addresses) {
			addressesDTO.add(new AddressDTO(address));
		}
		return addressesDTO;
	}

	@Transactional
	public boolean updateAddress(AddressDTO addressDTO) {
		Address address = null;
		if (addressDTO.getId() != 0) {
			address = addressDAO.getAddressById(addressDTO.getId());
		} else {
			address = (Address) addressDAO.getAddressByPostalCode(addressDTO.getPostalCode());
		}

		if (address != null) {

			address.setPostalCode(addressDTO.getPostalCode());
			
		}
		return addressDAO.updateAddress(address);
	}

	@Transactional
	public void deleteAddress(int id) {
		addressDAO.deleteAddress(id);
	}
}