package com.fortech.internship.dto;


public class AddressDTO {

	private int id;
	private String postalCode;
	
	public AddressDTO() {
	}
	
	public AddressDTO(String postalCode) {
		super();
		this.postalCode = postalCode;
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