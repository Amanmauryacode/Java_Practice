package com.masai.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	
	private static final EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("employee");
	}
	
	public static EntityManager provideEntityManager() {
		return emf.createEntityManager();
	}

}
