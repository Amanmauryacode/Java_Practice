package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Hotel;
import com.masai.model.Type;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Integer> {

	@Query("select h from Hotel h INNER JOIN RoomType rt ON h.hotelId= rt.hotel.hotelId where h.city=?1 And rt.type=?2")
	public List<Hotel> searchByCityAndRoomType(String city,Type rt);
}
