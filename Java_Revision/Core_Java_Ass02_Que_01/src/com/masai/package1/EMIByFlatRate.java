package com.masai.package1;

public class EMIByFlatRate implements EquatedMonthlyInstallment{

	@Override
	public double getEMIAmount(double principleAmount, double interestRate, double timePeriod) {
		// Flat rate EMI calculation principle amount + total interest for given time
		double amount = principleAmount + (principleAmount*interestRate*timePeriod)/100.00;
		
		return Math.round((amount/(12*timePeriod))*100)/100;
	}

}
