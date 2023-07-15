package com.masai;

public class FeeExpenses {

	private Double tuitionFee ;
	private Double serviceTax ;
	
	public FeeExpenses(Double tuitionFee, Double serviceTax) {
		
		this.tuitionFee = tuitionFee;
		this.serviceTax = serviceTax;
	}
	
	public Double getTotalFee(){
		return tuitionFee + (tuitionFee*serviceTax)/100;
	}

	public Double getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(Double tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public Double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(Double serviceTax) {
		this.serviceTax = serviceTax;
	}
	
	
}
