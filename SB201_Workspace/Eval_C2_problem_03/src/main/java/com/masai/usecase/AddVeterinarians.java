package com.masai.usecase;

import com.masai.Dao.VeterinarianDao;
import com.masai.Dao.VeterinariansDaoImpl;
import com.masai.entity.Pet;
import com.masai.entity.Veterinarian;
import com.masai.exception.VeterinarianException;

public class AddVeterinarians {

	public static void main(String[] args) {
		Veterinarian vt = new Veterinarian();
		
		vt.setVeterinarianId(1);
		vt.setName("xyz");;
		vt.setSpecialty("abc");;
		vt.setLocation("Varanasi");
		
		Pet p1 = new Pet();
		
		p1.setPetID(1);
		p1.setPetName("Dog");
		
		vt.getPetList().add(p1);
		p1.getVeterinarianList().add(vt);		
		VeterinarianDao dao = new VeterinariansDaoImpl();
		
		try {
			String msg = dao.addVeterinarians(vt);
			System.out.println(msg);
		} catch (VeterinarianException e) {
			System.out.println(e.getMessage());
		}
	}
}
