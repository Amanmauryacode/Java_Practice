package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.HotelException;
import com.masai.model.Hotel;
import com.masai.model.RoomType;
import com.masai.model.Type;
import com.masai.service.HotelService;

import jakarta.validation.Valid;

@RestController
public class HotelController {

	@Autowired
	private HotelService hs;
	
	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) throws HotelException{
		
		Hotel h = hs.addHotel(hotel);
		return new ResponseEntity<>(h,HttpStatus.CREATED);
	}
	
	@PatchMapping("/hotels/{id}")
	public ResponseEntity<Hotel> addNewHotelRoomType(@Valid @PathVariable("id") Integer id,@RequestBody RoomType rt) throws HotelException{
		
		Hotel h = hs.addRoomTypeInHotel(id, rt);
		return new ResponseEntity<>(h,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/hotels/City/{city}/type/{rt}")
	public ResponseEntity<List<Hotel>> searchHotelByCityAndType(@Valid @PathVariable String city, @PathVariable Type rt)
			throws HotelException{
		
		List<Hotel> hotels = hs.searchByRoomTYpeAndCity(city, rt);
		return new ResponseEntity<>(hotels,HttpStatus.OK);
	}
}
