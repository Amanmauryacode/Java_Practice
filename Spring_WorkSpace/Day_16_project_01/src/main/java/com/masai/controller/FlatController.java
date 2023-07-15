package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Flat;
import com.masai.service.FlatService;

import jakarta.validation.Valid;

@RestController
public class FlatController {

	@Autowired
	private FlatService flatService;
	@GetMapping("/flats/lessThan")
	public ResponseEntity<List<Flat>> getFlatByPriceLessThan(@Valid @RequestParam("price") Integer price){
		List<Flat> flats = flatService.findFlatByPriceLessThan(price);
		return new ResponseEntity<>(flats,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/flats/lessThanEqual")
	public ResponseEntity<List<Flat>> getFlatByPriceLessThanEqual(@Valid @RequestParam("price") Integer price){
		List<Flat> flats = flatService.findFlatByPriceLessThanEqualTo(price);
		return new ResponseEntity<>(flats,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/flats/greterThan")
	public ResponseEntity<List<Flat>> getFlatByPriceGreaterThan(@Valid @RequestParam("price") Integer price){
		List<Flat> flats = flatService.findFlatByPriceGreaterThan(price);
		return new ResponseEntity<>(flats,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/flats/between")
	public ResponseEntity<List<Flat>> getFlatByPriceBetween(@Valid @RequestParam("s_price") Integer s_price,@RequestParam("e_price") Integer e_price){
		List<Flat> flats = flatService.findFlatByPriceBetween(s_price, e_price);
		return new ResponseEntity<>(flats,HttpStatus.ACCEPTED);
	}
	@PostMapping("/flats")
	public ResponseEntity<Flat> registerFlat(@Valid @RequestBody Flat flat){
		Flat f = flatService.registerFlat(flat);
		return new ResponseEntity<>(f,HttpStatus.ACCEPTED);
	}
	
	
}
