package com.masai.Dao;

import javax.persistence.EntityManager;

import com.masai.entity.Applicant;
import com.masai.exception.ApplicantException;
import com.masai.utility.EMUtil;

public class JobPortalDaoOrmImpl implements JobPortalDAO {

	public Applicant findApplicantById(int id) {
		EntityManager em = EMUtil.getEntityManager();

		Applicant app = em.find(Applicant.class, id);
		em.close();
		if (app == null)
			throw new ApplicantException("Aplicant Not Founcd");
		return app;

	}

	public String saveApplicant(Applicant applicant) {
		EntityManager em = EMUtil.getEntityManager();

		Applicant app = em.find(Applicant.class, applicant.getId());
		if (app != null)
			throw new ApplicantException("Duplicate Aplicant Founcd");

		em.getTransaction().begin();
		em.persist(applicant);
		em.getTransaction().commit();
		em.close();

		return "Sucessfully Inserted";

	}

	public String deleteApplicantById(int id) {
		EntityManager em = EMUtil.getEntityManager();

		Applicant app = em.find(Applicant.class, id);
		
		if (app == null)
			throw new ApplicantException("Aplicant Not Founcd");
		
		em.getTransaction().begin();
		em.remove(app);
		em.getTransaction().commit();
		em.close();

		return "Sucessfully Deleted";
		
	}

	public String updateApplicantExperience(int id, int experience) {
		EntityManager em = EMUtil.getEntityManager();

		Applicant app = em.find(Applicant.class, id);
		
		if (app == null)
			throw new ApplicantException("Aplicant Not Founcd");
		
		em.getTransaction().begin();
		app.setExperience(experience);
		em.getTransaction().commit();
		em.close();

		return "Sucessfully Update";
	}
	// Implementation using ORM approach (Hibernate)
}

