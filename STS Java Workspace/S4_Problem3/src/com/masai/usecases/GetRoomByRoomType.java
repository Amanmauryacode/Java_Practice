package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.RoomDao;
import com.masai.dao.RoomDaoImpl;
import com.masai.exception.RoomException;
import com.masai.model.Room;

public class GetRoomByRoomType {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Room type to Search : ");
		String type = sc.next();
		
		sc.close();
		
		RoomDao dao = new RoomDaoImpl();
		
		try {
			Room room = dao.getRoomByRoomType(type);
			System.out.println(room);
		} catch (RoomException e) {

			System.out.println(e.getMessage());
		}
	}
}
