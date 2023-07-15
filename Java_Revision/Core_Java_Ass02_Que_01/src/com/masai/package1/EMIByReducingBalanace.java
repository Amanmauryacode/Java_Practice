package com.masai.package1;

public class EMIByReducingBalanace implements EquatedMonthlyInstallment {

	@Override
	public double getEMIAmount(double principleAmount, double interestRate, double timePeriod) {
		// Interest per month
		interestRate = interestRate/1200.00;
		
		//time period convert into month
		timePeriod = timePeriod*12;
		
		//Formula for Reducing Balance EMI 
		double amount = (principleAmount*interestRate)/(double) (1-Math.pow(1+interestRate, -1*timePeriod));
		return Math.round(amount*100)/100;
	}

}
