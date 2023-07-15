package com.masai;

public class EPFOAccount {
	private Integer accountNo;
	private Double balance;

	public EPFOAccount(Integer accountNo, Double balance) {
		
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
//		Account number: EPF001 Balance: 25500/-
		return "Account number:" + accountNo + " Balance: " + balance + "/-";
	}

	
}
