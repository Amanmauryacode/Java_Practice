package com.masai.Ass10;

public class SalariedPeople implements Taxation {
	int income ;
	SalariedPeople(int income ){
		this.income  = income;
	}
	@Override
	public double calculateTax(){
		
		if(income <=250000) {
			return 0.0;
		}
		
		else if(income <=500000) {
			double tax =(income- 250000)*0.10;
			return tax;
		}
		
		else if(income <=1000000) {
			double tax = (income - 500000)*0.20;
			return tax;
		}
		
		else{
			if(income >=10000000) {
				double tax = (income - 1000000)*0.30 + 150000 + 25000 + 750000;
				return tax;
			}
			double tax = (income - 1000000)*0.30 + 100000 + 25000;
			return tax;
		}
		
	}
}
