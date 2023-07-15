package com.masai;

public class FeeExpenses {
	private double tuitionFee;
	private double serviceTax;
	
	public FeeExpenses(double tuitionFee,double serviceTax){
		this.tuitionFee = tuitionFee;
		this.serviceTax = serviceTax;
	}
	double getTotalFee() {
		return tuitionFee+tuitionFee*(serviceTax/100);
	}
	public double getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(double tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public double getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}
	
	
}
