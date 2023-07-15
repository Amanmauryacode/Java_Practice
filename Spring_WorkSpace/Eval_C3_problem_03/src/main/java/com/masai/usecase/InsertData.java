package com.masai.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.masai.Dao.BikeOwnerDao;
import com.masai.Dao.BikeOwnerDaoImpl;
import com.masai.model.Bike;
import com.masai.model.BikeOwner;
import com.masai.utility.EMUtil;

public class InsertData {

	public static void main(String[] args) {
		
		
		BikeOwner bo1 = new BikeOwner( "Aman", "6306804122", "aman@gmail.com");
		BikeOwner bo2 = new BikeOwner( "Anuj", "7800596122", "anuj@gmail.com");
		BikeOwner bo3 = new BikeOwner( "Rahul", "1425369875", "rahul@gmail.com");
		BikeOwner bo4 = new BikeOwner( "Rounak", "1234569875", "rounak@gmail.com");
		
		Bike b1 = new Bike(1, "black", "passon");
		Bike b2 = new Bike(2, "white", "shine");
		Bike b3 = new Bike(3, "blue", "slender");
		Bike b4 = new Bike(4, "black", "mojo");
		
		bo1.setBike(b1);
		bo2.setBike(b2);
		bo3.setBike(b3);
		bo4.setBike(b4);
		
		List<BikeOwner> list = new ArrayList<>();
		
		list.add(bo1);
		list.add(bo2);
		list.add(bo3);
		list.add(bo4);
		
		BikeOwnerDao dao = new BikeOwnerDaoImpl();
		
		dao.InsertData(list);
	}
}
