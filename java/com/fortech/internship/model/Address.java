package com.fortech.internship.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name="postal_code")

   private String postalCode;
   public Address() {}
   
   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }
   
   public String getPostalCode() {
      return postalCode;
   }
   
   public void setPostalCode( String postalCode ) {
      this.postalCode = postalCode;
   }

}
