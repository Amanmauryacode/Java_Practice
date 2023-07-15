package com.masai.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BikeOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private String phoneNumber;
	private String emailId;

	@Embedded
	private Bike Bike;

	
	
	public BikeOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BikeOwner(String ownerName, String phoneNumber, String emailId) {
		super();
		this.ownerName = ownerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Bike getBike() {
		return Bike;
	}

	public void setBike(Bike bike) {
		Bike = bike;
	}

	@Override
	public String toString() {
		return "BikeOwner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ",\n Bike=" + Bike + "]";
	}

}
