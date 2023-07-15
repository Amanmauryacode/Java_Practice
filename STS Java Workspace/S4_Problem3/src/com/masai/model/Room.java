package com.masai.model;

public class Room {

	private int roomNumber;
	private String RoomType;
	private Double pricePerNight;
	private int maximumPerson;
	private boolean isEmpty;
	
	public Room() {
		
	}
	
	public Room(int roomNumber, String roomType, Double pricePerNight, int maximumPerson, boolean isEmpty) {
		super();
		this.roomNumber = roomNumber;
		RoomType = roomType;
		this.pricePerNight = pricePerNight;
		this.maximumPerson = maximumPerson;
		this.isEmpty = isEmpty;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public Double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getMaximumPerson() {
		return maximumPerson;
	}

	public void setMaximumPerson(int maximumPerson) {
		this.maximumPerson = maximumPerson;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public String toString() {
		return "roomNumber=" + roomNumber + ", RoomType=" + RoomType + ", pricePerNight=" + pricePerNight
				+ ", maximumPerson=" + maximumPerson + ", isEmpty=" + isEmpty + "\n";
	}
	
	
	
	
}
