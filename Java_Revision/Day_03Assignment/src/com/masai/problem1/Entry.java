package com.masai.problem1;

import java.time.LocalDate;

public class Entry {

    private String particular;
    private double amount;
    private LocalDate date;
    private char category;

    public Entry(String particular, double amount, LocalDate date, char category) {
        this.particular = particular;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public String getParticular() {
        return particular;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public char getCategory() {
        return category;
    }

    @Override
    public String toString() {
        if(category == 'E')
            return   date + "\t\t-" + amount + "\t\t" + particular;
        return   date + "\t\t"  + amount + "\t\t" + particular;


    }
}
