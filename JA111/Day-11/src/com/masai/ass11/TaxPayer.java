package com.masai.ass11;

import java.util.Objects;

public class TaxPayer {
	private String PAN;
	  private long adhaarNumber;
	  private String name;
	  
	  public TaxPayer(String PAN,long adhaarNumber,String name) {
		// TODO Auto-generated constructor stub
		  this.PAN = PAN;
		  this.adhaarNumber = adhaarNumber;
		  this.name = name;
	  }
	  //generate paremterized constructors
	  //generate getter & setter method
	  //override equals method that must return true if PAN and adhaar is same for calling and parameter object
	  //override the hashCode method to generate same hashcode for two taxpayers whose adhaar and PAN is same
	  //override the toString() method to return String representation of TaxPayer as follow-
	  // Name: <name>, PAN: <pan-number>, Adhaar Number: <adhaar-number> [See output for details]

		public String getPAN() {
			return PAN;
		}
		
		public void setPAN(String pAN) {
			PAN = pAN;
		}
		
		public long getAdhaarNumber() {
			return adhaarNumber;
		}
		
		public void setAdhaarNumber(long adhaarNumber) {
			this.adhaarNumber = adhaarNumber;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			return Objects.hash(PAN, adhaarNumber);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TaxPayer other = (TaxPayer) obj;
			return Objects.equals(PAN, other.PAN) && adhaarNumber == other.adhaarNumber;
		}
		
		
}
