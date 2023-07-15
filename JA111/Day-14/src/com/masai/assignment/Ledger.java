package com.masai.assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ledger {
	List<Entry> income = new ArrayList<>();
	List<Entry> expense = new ArrayList<>();
	
	void addExpense(Entry expeEntry) {
		expense.add(expeEntry);
	}
	
	void addIncome(Entry incomeEntry) {
		income.add(incomeEntry);
	}
	
	 double getTotalExpenses() {
		 double totalexp = 0.0;
		 
		 for(Entry item : expense) {
			 totalexp+=item.getIncome();
		 }
		 return totalexp;
	 }
	 
	 double getTotalIncome() {
		 double totalincome = 0.0;
		 
		 for(Entry item : income) {
			 totalincome+=item.getIncome();
		 }
		 return totalincome;
	 }
	 
	 String getRemarkOnFinHealth() {
		 
		 if(getTotalExpenses() <= 0.7*getTotalIncome()) {
			 return"Your financial health is good";
		 }else if(getTotalExpenses() == getTotalIncome()) {
			 return "You need to increase the saving";
		 }else {
			 return "You need to manage expenses well also try to increase income";
		 }
	 }
	 
	 List<Entry> getHighestLowestExpenseIncomeEntries(){
		 List<Entry> arr = new ArrayList<>();
		 
		 return arr;
	 }

	public List<Entry> getIncomeByDateRange(LocalDate parse, LocalDate parse2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteExpensesExcludingAmountRange(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
