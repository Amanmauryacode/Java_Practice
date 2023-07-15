package com.masai.package1;

public class Demo {

	public static void main(String[] args) {

		EMIByFlatRate flatrate = new EMIByFlatRate();
		
		System.out.println("---------------------------------------");

		System.out.println("EMI by Flat Rate : " + flatrate.getEMIAmount(2000, 7, 1));

		System.out.println("---------------------------------------");

		EMIByReducingBalanace reducingBalance = new EMIByReducingBalanace();

		System.out.println("EMI by Reducing Balanace : " + reducingBalance.getEMIAmount(2000, 7, 1));

		System.out.println("---------------------------------------");
	}
}
