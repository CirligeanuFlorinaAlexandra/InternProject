package com.fortech.internship.model;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "faculty")
public class Faculty {
	
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="universityId", nullable=false)
   private University university;

	public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

	@ManyToOne()
	@JoinColumn(name = "address_id", nullable = false)
    private Address address;


   public Faculty() {}

   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName( String name ) {
      this.name = name;
   }

	public University getUniversity() {
		return university;
	}
	
	public void setUniversity(University university) {
		this.university = university;
	}

}