package com.masai.problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class SortByAmount implements Comparator<Entry> {

    @Override
    public int compare(Entry o1, Entry o2) {
        if(o1.getAmount() > o2.getAmount()){
            return 1;
        } else if (o1.getAmount() < o2.getAmount()) {
            return -1;
        }else{
            return 0;
        }
    }
}

class SortByDate implements Comparator<Entry> {

    @Override
    public int compare(Entry o1, Entry o2) {
        return o1.getDate().compareTo(o2.getDate());

    }
}

public class Ledger {

    List<Entry> expenseEntries;
    List<Entry> incomeEntries;

    public Ledger(){
        expenseEntries = new ArrayList<>();
        incomeEntries = new ArrayList<>();
    }

    void addExpense(Entry expeEntry){
        expenseEntries.add(expeEntry);
    }

    void addIncome(Entry incomeEntry){
        incomeEntries.add(incomeEntry);
    }

    double getTotalExpenses(){
        double totalAmount = 0.0;

        Iterator<Entry> itr = expenseEntries.iterator();
        while (itr.hasNext()){
            totalAmount += itr.next().getAmount();
        }
        return totalAmount;
    }

    double getTotalIncome(){
       double totalIncome = 0.0;

     for(Entry entry : incomeEntries){
           totalIncome += entry.getAmount();
       }
       return totalIncome;
    }

    String getRemarkOnFinHealth(){

        double totalExp = getTotalExpenses();
        double totalInc = getTotalIncome();

        if(0.7 * totalInc >= totalExp){
            return "Your financial health is good";
        }
        if(totalInc >= totalExp){
            return "You need to increase the saving";
        }

        return "You need to manage expenses well also try to increase income";
    }

    List<Entry> getHighestLowestExpenseIncomeEntries(){
        List<Entry> entry = new ArrayList<>();

        entry.add(Collections.max(expenseEntries, new SortByAmount()));
        entry.add(Collections.min(expenseEntries, new SortByAmount()));

        entry.add(Collections.max(incomeEntries, new SortByAmount()));
        entry.add(Collections.min(expenseEntries, new SortByAmount()));

        return entry;
    }

    List<Entry> getIncomeByDateRange(LocalDate startDate, LocalDate endDate){
        List<Entry> entry = new ArrayList<>();

        for(Entry ent : incomeEntries){
            LocalDate ld = ent.getDate();

            if(ld.isAfter(endDate.minusDays(1)) && ld.isBefore(endDate.plusDays(1))){
                entry.add(ent);
            }
        }

        return entry;
    }

    void deleteExpensesExcludingAmountRange(double from, double to){
            
    }

    @Override
    public String toString() {
        List<Entry> entries = new ArrayList<>();
        entries.addAll(incomeEntries);
        entries.addAll(expenseEntries);

     Collections.sort(entries,new SortByDate());

     StringBuilder str = new StringBuilder();
     for (Entry ent : entries){
         str.append(ent + "\n");
     }
     double grandTotal = getTotalIncome()-getTotalExpenses();
     str.append("Grand total is: " + grandTotal);

     String output  = str.toString();

     return  output;
    }
}




