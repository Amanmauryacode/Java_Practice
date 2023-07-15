package com.masai.service;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.masai.model.ArtistManagement;

@Service
@Lazy(value = true)
public class EventOrganizerImpl implements EventOrganizer {

	@Autowired(required = false)
	@Qualifier("singer")
	ArtistManagement artistManagement;

	@Override
	public void findArtist(String message) {
		artistManagement.announceAvailability(message);
	}

	@PostConstruct
	public void eventInfo() {
		System.out.println("Date of the Event : " + LocalDate.now());
		System.out.println("Venue of Event : Varanasi");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Thankyou for Attending the Event");
	}
}
