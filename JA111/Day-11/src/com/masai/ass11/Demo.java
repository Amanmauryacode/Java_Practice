package com.masai.ass11;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	/**Method to check if PAN is valid or Not
	    * @param PAN: String, The PAN of User
	    * @return true if PAN number is valid according to format, false otherwise
	    */
	  static boolean checkPAN(String PAN) {
	    //write code to validate the PAN number using regular expression
		  Pattern  pt = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		  Matcher m = pt.matcher(PAN);
		  
		  return m.matches();
	  }

	  /**
	    * Method to check if adhaar number is valid or Not
	    * @param adhaarNumber: long, The adhaar number of User
	    * @return true if adhaar number is valid according to format, false otherwise
	    */
	  static boolean checkAdhaar(long adhaarNumber) {
	    //write code to validate the adhaarNumber number using regular expression
		  
		  Pattern  pt = Pattern.compile("[0-9]{12}");
		  Matcher m = pt.matcher(String.valueOf(adhaarNumber));
		  
		  return m.matches();
	  }

	  /**
	    * Method to add new tax payer to array of tax payers iff new tax has unique combination of PAN and adhaar
	    * @param tpArr: TaxPayer[] The array of TaxPayers in which tax payers to be added
	    * @param newTP: TaxPayer The taxpayer to be added to the array
	    * @return: true if the taxpayer added to the array, false otherwise
	    */
	  static boolean addTaxPayer(TaxPayer tpArr[], TaxPayer newTP) {
	    //Write code to add newTP to tpArr if taxpayers with newTP's PAN and adhaar is not here
		  boolean flag = true;
		 
		  
	
		  for(int i=0;i<tpArr.length;i++) {
			  if(tpArr[i] == null) {
				  tpArr[i] = newTP;
				  flag = true;
				  break;
			  }
			  
			  if(tpArr[i].equals(newTP)) {
				  flag = false;
				  break;
			  }
		  }

		  
		  
		  
		  return flag;
		  
		  
	  }

	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    //Create an array of objects
	    TaxPayer tpArr[] = new TaxPayer[5];
	    int totalTaxPayers = 0;

	    while(true) {
	      System.out.print("Please enter name, PAN and adhaar Number ");
	      String name = sc.next();
	      String panNumber = sc.next();
	      long adhaarNumber = sc.nextLong();
	      if(checkPAN(panNumber) && checkAdhaar(adhaarNumber)) {
	        //you are here means PAN and adhaar are in correct format
	        if(addTaxPayer(tpArr, new TaxPayer(panNumber, adhaarNumber, name))) {
	          //you are here means tax payer has added to the array
	          System.out.println("Yahoo! Tax payer added\n");
	          if(++totalTaxPayers == tpArr.length)
	            //the array is full so better to break the loop
	            break;
	        }else {
	          System.out.println("Tax Payer with this PAN & adhaar already exists\n");
	        }
	      }else {
	        System.out.println("Enter correct PAN & adhaar number\n");
	      }
	    }

	    System.out.println("Details of tax payers are as follow-");
	    for(TaxPayer tp: tpArr)
	      System.out.println(tp);
	    sc.close();
	  }
}
