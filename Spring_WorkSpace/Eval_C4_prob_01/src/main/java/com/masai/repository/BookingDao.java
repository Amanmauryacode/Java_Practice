package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b INNER JOIN Customer c ON b.customer.customerId = c.customerId WHERE b.customer.customerId = :id And b.bookingDate BETWEEN :sd AND :ed")
	public List<Booking> bookingListBtDate(@Param("id") Integer id,@Param("sd")LocalDate s_date,@Param("ed") LocalDate e_date);
}
