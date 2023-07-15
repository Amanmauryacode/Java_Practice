package com.masai.Dao;

import java.util.List;
import java.util.Map;

import com.masai.model.Bike;
import com.masai.model.BikeOwner;

public interface BikeOwnerDao {

	public void InsertData(List<BikeOwner> list);
	
	public List<BikeOwner> getAllBikeOwnerWithBike();
	
	public List<BikeOwner> findBikeOwnersByBikeColor(String bikeColor);
	
	public Map<BikeOwner, Bike> topBikesByModelName(int n);
}
