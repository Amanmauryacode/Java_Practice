package com.masai.usecase;

import com.masai.Dao.VeterinarianDao;
import com.masai.Dao.VeterinariansDaoImpl;
import com.masai.entity.Pet;
import com.masai.exception.VeterinarianException;

public class RegisterPet {

	public static void main(String[] args) {
		Pet p1 = new Pet();

		p1.setPetID(1);
		p1.setPetName("Dog");

		VeterinarianDao dao = new VeterinariansDaoImpl();

		try {
			String msg= dao.RegisterPet(p1, 1);
			System.out.println(msg);
		} catch (VeterinarianException e) {
			System.out.println(e.getMessage());
		}
	}
}
