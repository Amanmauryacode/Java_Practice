package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.RoomDao;
import com.masai.dao.RoomDaoImpl;
import com.masai.exception.RoomException;
import com.masai.model.Room;

public class AddRoom {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Room No. : ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Enter RoomType : ");
		String roomType = sc.next();
		
		System.out.print("Enter Price Per Night : ");
		Double pricePerNight = sc.nextDouble();
		
		System.out.print("Enter Maximum Person : ");
		int maximumPerson = sc.nextInt();
		
		System.out.print("Enter Is Empty : ");
		boolean isEmpty = sc.nextBoolean();
		
		sc.close();
		
		Room r = new Room();
		r.setRoomNumber(roomNumber);
		r.setRoomType(roomType);
		r.setPricePerNight(pricePerNight);
		r.setMaximumPerson(maximumPerson);
		r.setEmpty(isEmpty);
		
		RoomDao dao = new RoomDaoImpl();
		
		try {
			String msg = dao.addRoom(r);
			System.out.println(msg);
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
