package com.masai.usecase;

import com.masai.Dao.VeterinarianDao;
import com.masai.Dao.VeterinariansDaoImpl;
import com.masai.exception.PetException;
import com.masai.exception.VeterinarianException;

public class RegisterPetWithVeterinarian {

	public static void main(String[] args) {
		VeterinarianDao dao = new VeterinariansDaoImpl();

		try {
			String msg = dao.registerPetWithVeterinarian(1, 2);
			System.out.println(msg);
		} catch (VeterinarianException e) {
			System.out.println(e.getMessage());
		} catch (PetException e) {
			System.out.println(e.getMessage());
		}
	}
}
