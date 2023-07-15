package com.masai.Dao;

import javax.persistence.EntityManager;

import com.masai.entity.Pet;
import com.masai.entity.Veterinarian;
import com.masai.exception.PetException;
import com.masai.exception.VeterinarianException;
import com.masai.utility.EMUtil;

public class VeterinariansDaoImpl implements VeterinarianDao {

	@Override
	public String addVeterinarians(Veterinarian vt) throws VeterinarianException {

		EntityManager em = EMUtil.provideEntityManager();
		if (vt == null) {
			throw new VeterinarianException("Veterinarians Object is Null");
		}

		Veterinarian v = em.find(Veterinarian.class, vt.getVeterinarianId());
		if (v != null)
			throw new VeterinarianException("Veterinarians Alerady Register");

		em.getTransaction().begin();
		em.persist(vt);
		em.getTransaction().commit();

		em.close();
		return "Sucessfully Inserted";
	}

	@Override
	public Veterinarian fetchVeterinarian(int id) throws VeterinarianException {
		EntityManager em = EMUtil.provideEntityManager();

		Veterinarian v = em.find(Veterinarian.class, id);
		if (v == null)
			throw new VeterinarianException("Veterinarians Not Found!");

		return v;
	}

	@Override
	public String RegisterPet(Pet pet, int id) throws VeterinarianException {
		EntityManager em = EMUtil.provideEntityManager();

		Veterinarian vt = em.find(Veterinarian.class, id);
		if (vt == null)
			throw new VeterinarianException("Veterinarians Not Found!");

		em.getTransaction().begin();
		pet.getVeterinarianList().add(vt);
		vt.getPetList().add(pet);
		em.getTransaction().commit();
		return "Sucessfully register";
	}

	@Override
	public Pet fetchPet(int id) throws PetException {
		EntityManager em = EMUtil.provideEntityManager();

		Pet pet = em.find(Pet.class, id);

		if (pet == null)
			throw new PetException("Pet Not Found!");

		return pet;
	}

	@Override
	public String registerPetWithVeterinarian(int petId, int vt_id) throws VeterinarianException, PetException {
		EntityManager em = EMUtil.provideEntityManager();

		Pet pet = em.find(Pet.class, petId);
		Veterinarian vt = em.find(Veterinarian.class, vt_id);
		if (pet == null)
			throw new PetException("Pet Not Found!");

		if (vt == null)
			throw new VeterinarianException("Veterinarians Not Found!");

		em.getTransaction().begin();
		pet.getVeterinarianList().add(vt);
		vt.getPetList().add(pet);
		em.getTransaction().commit();
		em.close();
		return "Sucessfully Register With Another Veterinarian";
	}

}
