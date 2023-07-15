package com.masai.Ass10;

public class BusinessPeople implements Taxation {
	int totalSale ;
	int totalPurches;
	int operationExpence;
	
	BusinessPeople(int tS,int tP,int oE){
		this.totalSale =tS ;
		this.totalPurches=tP ;
		this.operationExpence = oE;
	}
	
	@Override
	public double calculateTax(){
			
		double netProfit = totalSale - ( totalPurches + operationExpence );
			double tax = 0.0;
		if(netProfit <=500000) {
			return  0.0;
		}
		else if(netProfit <=1500000) {
			tax = (netProfit - 500000)*0.10;
		}
		else if(netProfit <=5000000) {
			tax = (netProfit - 1500000)*0.22 + 1000000*0.10;
		}
		else{
			if(netProfit > 50000000) {
				tax = (netProfit - 5000000)*0.32+3500000*0.22 + 1000000*0.10 + 1250000;
			}else {
				tax = (netProfit - 5000000)*0.32+3500000*0.22 + 1000000*0.10;
			}
			
		}
		
		
		return tax;
		
	}
}
