package com.fortech.internship.dto;


import com.fortech.internship.model.Address;

public class AddressDTO {

	private int id;
	private String postalCode;
	
	public AddressDTO() {
	}
	
	public AddressDTO(String postalCode) {
		super();
		this.postalCode = postalCode;
	}
	public AddressDTO(Address address) {
		this.id = address.getId();
		this.postalCode = address.getPostalCode();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}