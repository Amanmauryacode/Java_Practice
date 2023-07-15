package com.masai.Utitlity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {

	private static final EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("employee");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
