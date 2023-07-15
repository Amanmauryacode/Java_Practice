package com.masai.model;

public class Company {

	private String companyId;
	private String companyName;
	private long turnover_in_crores;
	private String registrationDate;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	public Company(String companyId, String companyName, long turnover_in_crores, String registrationDate) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover_in_crores = turnover_in_crores;
		this.registrationDate = registrationDate;
	}
	
	@Override
	public String toString() {
		return "companyId=" + companyId + ", companyName=" + companyName + ", turnover_in_crores="
				+ turnover_in_crores + ", registrationDate=" + registrationDate + "\n";
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getTurnover_in_crores() {
		return turnover_in_crores;
	}

	public void setTurnover_in_crores(long turnover_in_crores) {
		this.turnover_in_crores = turnover_in_crores;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	
	
	
} 
