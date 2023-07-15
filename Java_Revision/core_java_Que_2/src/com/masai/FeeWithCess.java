package com.masai;

public class FeeWithCess extends FeeExpenses {

	private Double cess; 
	
	public FeeWithCess(Double tuitionFee, Double serviceTax,Double cess) {
		super(tuitionFee, serviceTax);
		// TODO Auto-generated constructor stub
		this.cess = cess;
	}
	@Override
	public Double getTotalFee() {
		return cess + super.getTotalFee();
		
	}
	public Double getCess() {
		return cess;
	}
	public void setCess(Double cess) {
		this.cess = cess;
	}
	
	

}
