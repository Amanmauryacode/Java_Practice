package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.masai.exception.RoomException;
import com.masai.model.Customer;
import com.masai.model.Room;
import com.masai.utility.DBUtil;

public class RoomDaoImpl implements RoomDao {

	@Override
	public String addRoom(Room room) throws RoomException {
		String msg = "Not Inserted Room Data";
		
		try(Connection con = DBUtil.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("insert into room values(?,?,?,?,?)");
			
			ps.setInt(1, room.getRoomNumber());
			ps.setString(2, room.getRoomType());
			ps.setDouble(3, room.getPricePerNight());
			ps.setInt(4, room.getMaximumPerson());
			ps.setBoolean(5, room.isEmpty());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Data Inserted Sucessfully...";
			}else
				throw new RoomException("Invalid Data Entry...");
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public Room getRoomByRoomType(String name) throws RoomException {
		Room room = null;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from room where roomType = ?");
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				room = new Room();
				
				room.setRoomNumber(rs.getInt("roomNumber"));
				room.setRoomType(rs.getString("roomtype"));
				room.setPricePerNight(rs.getDouble("pricePerNight"));
				room.setMaximumPerson(rs.getInt("maximumPerson"));
				room.setEmpty(rs.getBoolean("isEmpty"));
				
			}else
				throw new RoomException("Room Details not found of Room Type : "+name);			
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return room;
	}

	@Override
	public List<Room> getEmptyRoom() throws RoomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCustomerToRoom(Customer customer, int roomNumber) throws RoomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeCustomerFromRoom(int customerId, int roomNumber) throws RoomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerFromParticularRoom(int roomNumber) throws RoomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getAllRoomDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
