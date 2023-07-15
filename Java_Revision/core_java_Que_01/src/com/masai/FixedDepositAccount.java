package com.masai;

public class FixedDepositAccount {

	Double depositeAmount;
	Double fdInterestRate;
	public FixedDepositAccount(Double depositeAmount, Double fdInterestRate) {
		
		this.depositeAmount = depositeAmount;
		this.fdInterestRate = fdInterestRate;
	}
	
	public Double calculateMaturityValue() {
		return depositeAmount * (1 + fdInterestRate/100);
	}
	
}
