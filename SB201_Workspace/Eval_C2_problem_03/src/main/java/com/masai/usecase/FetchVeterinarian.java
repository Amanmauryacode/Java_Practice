package com.masai.usecase;

import com.masai.Dao.VeterinarianDao;
import com.masai.Dao.VeterinariansDaoImpl;
import com.masai.entity.Veterinarian;
import com.masai.exception.VeterinarianException;

public class FetchVeterinarian {

	public static void main(String[] args) {
		VeterinarianDao dao = new VeterinariansDaoImpl();
		
		try {
			Veterinarian v = dao.fetchVeterinarian(1);
			System.out.println(v);
		} catch (VeterinarianException e) {
			System.out.println(e.getMessage());
		}
	}
}
