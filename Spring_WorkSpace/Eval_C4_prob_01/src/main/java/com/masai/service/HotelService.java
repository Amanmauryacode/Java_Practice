package com.masai.service;

import java.util.List;

import com.masai.exception.HotelException;
import com.masai.model.Hotel;
import com.masai.model.RoomType;
import com.masai.model.Type;

public interface HotelService {

	public Hotel addHotel(Hotel hotel)throws HotelException;
	
	public Hotel addRoomTypeInHotel(Integer HotelId,RoomType rt)throws HotelException;
	
	public List<Hotel> searchByRoomTYpeAndCity(String city,Type rt) throws HotelException ;
}
