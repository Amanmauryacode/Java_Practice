package com.masai.Dao;

public class GetJob {
	public static JobPortalDAO getInstanceofJobPortalDAO(String approach) {

		if (approach.equals("ORM")) {
			return new JobPortalDaoOrmImpl();
		} else if (approach.equals("JDBC")) {
			return new JobPortalDAOJdbcImpl();
		}
		return null;
		// This method will return an instance of JobPortalDAO.
	}
}