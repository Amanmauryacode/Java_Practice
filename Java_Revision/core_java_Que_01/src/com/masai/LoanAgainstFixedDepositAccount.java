package com.masai;

public class LoanAgainstFixedDepositAccount extends FixedDepositAccount {

	Double loanAmount ;
	Double loanInterestRate ;
	public LoanAgainstFixedDepositAccount(Double depositeAmount, Double fdInterestRate,Double loanAmount ,Double loanInterestRate ) {
		super(depositeAmount, fdInterestRate);
		this.loanAmount = loanAmount;
		this.loanInterestRate = loanInterestRate;
	}
	
	Double calculateTotalPayment() {
		return loanAmount + (loanAmount * loanInterestRate) / 100;
	}

}
