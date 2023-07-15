package com.masai.usecase;

import com.masai.Dao.VeterinarianDao;
import com.masai.Dao.VeterinariansDaoImpl;
import com.masai.entity.Pet;
import com.masai.exception.PetException;

public class FetchPet {
	public static void main(String[] args) {
		VeterinarianDao dao = new VeterinariansDaoImpl();
		
		try {
			Pet pet = dao.fetchPet(1);
			System.out.println(pet);
			pet.getVeterinarianList().forEach(System.out::println);
		} catch (PetException e) {
			System.out.println(e.getMessage());
		}
	}
}
