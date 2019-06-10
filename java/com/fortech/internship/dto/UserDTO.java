package com.fortech.internship.dto;
import com.fortech.internship.dao.Level;
import com.fortech.internship.model.User;
import com.fortech.internship.service.impl.mapper.ToDTO;

public class UserDTO {
	private int id;
	private String name;
	private String email;
	private AddressDTO addressDTO;
	private int accessLevel;
	private boolean approved;
	private FacultyDTO facultyDTO;

	public UserDTO() {
	}

	public UserDTO(String name, String email, AddressDTO addressDTO, int accessLevel, boolean approved, FacultyDTO facultyDTO) {
		super();
		this.name = name;
		this.email = email;
		this.addressDTO = addressDTO;
		this.accessLevel = accessLevel;
		this.approved = approved;
		this.facultyDTO = facultyDTO;
	}

	public FacultyDTO getFacultyDTO() {
		return facultyDTO;
	}

	public void setFacultyDTO(FacultyDTO facultyDTO) {
		this.facultyDTO = facultyDTO;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public boolean getApproved() {
		return approved;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
}
