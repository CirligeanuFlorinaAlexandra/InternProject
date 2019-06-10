package com.fortech.internship.dto;

public class CityDTO {
	private int id;
	private String name;
	private AddressDTO addressDTO;


	public CityDTO() {
	}

	public CityDTO(String name, int id, AddressDTO addressDTO) {
		super();
		this.name = name;
		this.id = id;
		this.addressDTO = addressDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

}
