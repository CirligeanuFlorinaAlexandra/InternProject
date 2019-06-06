package com.fortech.internship.model;

import javax.persistence.Column;

import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortech.internship.dao.Level;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private String email;
	
	private boolean approved;
	
	@Column
	private int accesLevel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_faculty", nullable=false)
	private Faculty faculty;
	
	public int getAccesLevel() {
		return accesLevel;
	}

	public void setAccesLevel(int accesLevel) {
		this.accesLevel = accesLevel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_address", nullable=false)
	private Address address;
	
	public User() {
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

	public boolean getApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getAccessLevel() {
		return accesLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accesLevel = accessLevel;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address.toString() + ", accessLevel=" + null//accessLevel
				+ ", approved=" + approved + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getAccessLevel()=" + null + ", getApproved()="
				+ getApproved() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
