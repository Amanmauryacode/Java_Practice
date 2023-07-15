package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.HotelException;
import com.masai.model.Hotel;
import com.masai.model.RoomType;
import com.masai.model.Type;
import com.masai.repository.HotelDao;
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	@Override
	public Hotel addHotel(Hotel hotel) throws HotelException {
		if(hotel == null)throw new HotelException("Hotel Details Not Found");
		return hotelDao.save(hotel);
	}

	@Override
	public Hotel addRoomTypeInHotel(Integer HotelId,RoomType rt) throws HotelException {
		
		Optional<Hotel> opt = hotelDao.findById(HotelId);
		if(opt.isEmpty())throw new HotelException("Hotel Details Not Found With id "+HotelId);
		
		Hotel h = opt.get();
		h.getRootTypes().add(rt);
		return hotelDao.save(h);
	}

	@Override
	public List<Hotel> searchByRoomTYpeAndCity(String city, Type rt) throws HotelException {
		
		List<Hotel> list = 	hotelDao.searchByCityAndRoomType(city, rt);
		
		if(list.isEmpty())throw new HotelException("Hotels Not Found in City "+city+" Of Type "+rt);
		return list;
	}

}
