package com.masai.eval.problem5a;

public class LoanMain {
	public static void main(String[] args) {
		MyLoanIntr l1 = Loan::new;
		
		Loan l = l1.creatrLoan(150000, 3, 8.5);
		System.out.println(l);
		
		LoanOperation op = new LoanOperation();
		
		GetEMIAmount emi1 = op::getEMIByFlatRate;
		
		System.out.println(emi1.getEMItoFlatRate(l));
		GetEMIAmount2 emi2 = LoanOperation::getEMIByFloatingRate;
		System.out.println(emi2.getEMIByFloatingRate(l));
	}
}
