package com.fortech.internship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fortech.internship.dao.AddressDAO;
import com.fortech.internship.dto.AddressDTO;
import com.fortech.internship.model.Address;
import com.fortech.internship.service.impl.AddressService;

@RestController
public class AddressController {

	/*
	 * @Autowired private AddressDAO addressDAOImpl;
	 * 
	 *//*** Creating a new Address ***/
	/*
	 * @RequestMapping(value = "/createAddress", method = RequestMethod.POST,
	 * produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	 * MediaType.APPLICATION_JSON_VALUE }) public void createAddress(@RequestBody
	 * AddressDTO addressDTO) { addressDAOImpl.createAddress(addressDTO); }
	 * 
	 * 
	 *//*** Retrieve a single Address ***/
	/*
	 * @RequestMapping(value = "/address/{id}", produces = "application/json",
	 * method = RequestMethod.GET) public AddressDTO
	 * getFacultyById(@PathVariable("id") int id) { AddressDTO address =
	 * addressDAOImpl.getAddressById(id); return address; }
	 * 
	 *//*** Retrieve all Faculties ***/
	/*
	 * @RequestMapping(value = "/adresses", produces = "application/json", method =
	 * RequestMethod.GET) public List<AddressDTO> getAllAddresses() { return
	 * addressDAOImpl.getAllAddresses(); }
	 * 
	 *//*** Update an Address ***/
	/*
	 * @RequestMapping(value = "/updateAddress", method = RequestMethod.PUT,
	 * produces = "application/json", consumes = "application/json") public void
	 * updateAddress(@RequestBody AddressDTO addressDTO) { boolean updatedAddress =
	 * addressDAOImpl.updateAddress(addressDTO); System.out.println(updatedAddress);
	 * }
	 * 
	 *//*** Delete an Address ***//*
									 * @RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.DELETE,
									 * produces = "application/json") public void deleteAddress(@PathVariable("id")
									 * int id) { addressDAOImpl.deleteAddress(id); } }
									 */

	@Autowired
	private AddressService addressService;

	/**
	 * * Creating a new Address **
	 */
	@RequestMapping(value = "/createAddress", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void createAddress(@RequestBody AddressDTO addressDTO) {
		addressService.createAddress(addressDTO);
	}

	/**
	 * * Retrieve a single Address **
	 */
	@RequestMapping(value = "/address/{id}", produces = "application/json", method = RequestMethod.GET)
	public Address getAddressById(@PathVariable("id") int id) {
		Address address = addressService.getAddressById(id);
		return address;
	}

	/**
	 * * Retrieve all Addresses **
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/adresses", produces = "application/json", method = RequestMethod.GET)
	public List getAllAddresses() {
		List addressList = (List) addressService.getAllAddresses();
		return addressList;
	}

	/**
	 * * Update an Address **
	 */
	@RequestMapping(value = "/updateAddress", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateAddress(@RequestBody AddressDTO addressDTO) {
		boolean updatedAddress = addressService.updateAddress(addressDTO);
		System.out.println(updatedAddress);
	}

	/**
	 * * Delete an Address **
	 */

	@RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteAddress(@PathVariable("id") int id) {
		addressService.deleteAddress(id);
	}
}
