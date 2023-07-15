package com.masai;

public class FeeWithCess extends FeeExpenses{
	private double cess;
	
	public FeeWithCess(double tuitionFee,double serviceTax,double cess) {
		// TODO Auto-generated constructor stub
		super(tuitionFee,serviceTax);
		this.cess = cess;
	}
	
	
	@Override
	double getTotalFee() {
		// TODO Auto-generated method stub
		return super.getTotalFee() + super.getTuitionFee()*(cess/100);
	}
}
