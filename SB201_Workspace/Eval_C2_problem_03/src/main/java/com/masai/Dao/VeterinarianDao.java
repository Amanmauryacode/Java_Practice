package com.masai.Dao;

import com.masai.entity.Pet;
import com.masai.entity.Veterinarian;
import com.masai.exception.PetException;
import com.masai.exception.VeterinarianException;

public interface VeterinarianDao {

	public String addVeterinarians(Veterinarian vt) throws VeterinarianException;

	public Veterinarian fetchVeterinarian(int id) throws VeterinarianException;
	
	public String RegisterPet(Pet pet ,int id) throws VeterinarianException;
	
	public Pet fetchPet(int id) throws PetException;
	
	public String registerPetWithVeterinarian(int petId,int vt_id) throws VeterinarianException,PetException;
}
