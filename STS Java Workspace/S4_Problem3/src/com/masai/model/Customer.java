package com.masai.model;

public class Customer {

	private int customerID;
	private String customerName;
	private String address;
	private int roomNumber;
	
	public Customer() {
		
	}

	public Customer(int customerID, String customerName, String address, int roomNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.roomNumber = roomNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "customerID=" + customerID + ", customerName=" + customerName + ", address=" + address
				+ ", roomNumber=" + roomNumber + "\n";
	}
	
	
	
}
