package com.masai.model;

public class Company {
	private String companyId;
	private String companyName;
	private long turnover;
	private String registretionDate;
	
	public Company() {
		
	}
	
	public Company(String companyId, String companyName, long turnover, String registretionDate) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover = turnover;
		this.registretionDate = registretionDate;
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

	public long getTurnover() {
		return turnover;
	}

	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}

	public String getRegistretionDate() {
		return registretionDate;
	}

	public void setRegistretionDate(String registretionDate) {
		this.registretionDate = registretionDate;
	}

	@Override
	public String toString() {
		return "companyId=" + companyId + ", companyName=" + companyName + ", turnover=" + turnover
				+ ", registretionDate=" + registretionDate + "\n";
	}
	
	
	
}
