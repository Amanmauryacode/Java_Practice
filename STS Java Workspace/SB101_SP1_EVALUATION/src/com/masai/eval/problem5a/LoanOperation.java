package com.masai.eval.problem5a;

public class LoanOperation {
	double getEMIByFlatRate(Loan loan) {
		double totalIntrest = loan.getInterestRate()*(loan.getTimePeriod());
		return (loan.getPrincipleAmount()+(totalIntrest/100)*loan.getPrincipleAmount())/(loan.getTimePeriod()*12);
	}
	
	static double getEMIByFloatingRate(Loan loan) {
//		EMI = p * ((r * (1 + r)^n) / ((1 + r)^n - 1)) [Here ^ is for power not for XOR operation]
//
//		Here p is principle amount r = interestRate / 1200 
//
//		n = no of payment term in months (i.e. for payment term of 3 year it will be 36 month)
		
		double r = loan.getInterestRate()/1200;
		double n = loan.getTimePeriod()*12;
		double p = loan.getPrincipleAmount();
		
		return  p * ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1)) ;
	}
}
