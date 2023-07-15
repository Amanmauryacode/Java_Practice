package com.masai.dao;

import java.util.List;

import com.masai.exception.RoomException;
import com.masai.model.Customer;
import com.masai.model.Room;

public interface RoomDao {

	public String addRoom(Room room) throws RoomException;
	

	public Room getRoomByRoomType(String name)throws RoomException;
	

	public List<Room> getEmptyRoom()throws RoomException;
	

	public String addCustomerToRoom(Customer customer, int roomNumber)throws RoomException;
	

	public String removeCustomerFromRoom(int customerId, int roomNumber)throws   RoomException;
	

	public List<Customer> getCustomerFromParticularRoom(int roomNumber) throws      RoomException;
	

	public List<Room> getAllRoomDetails();

}
