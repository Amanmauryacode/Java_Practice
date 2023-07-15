package com.masai.package1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TBillDemo {

	public static LocalDate getMaturityDate(String auctionDesc) {
		String[] DTB = auctionDesc.split(" ");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyy");

		return LocalDate.parse(DTB[2], dtf);
	}

	public static LocalDate getSettlementDate(LocalDate maturityDate, String auctionDesc) {
		int days = Integer.parseInt(auctionDesc.split(" ")[0]);
		LocalDate ld = maturityDate.minusDays(days);
		return ld;
	}

	public static LocalDate getAnotherDate(LocalDate settlementDate, int days) {
		LocalDate ld = settlementDate.plusDays(days - 1);
		return ld;
	}

	public static double getInitialInvestementAmount(double maturityAmount, String auctionDesc)
			throws InvalidMaturityAmountException {
		if (maturityAmount % 10000.00 == 0) {
			String[] DTB = auctionDesc.split(" ");
			double initialiInvestement = (double) 100.00
					/ (((Double.parseDouble(DTB[3]) * Double.parseDouble(DTB[0])) / (36500.00)) + 1)
					* (maturityAmount / 100.00);
			return Math.round(initialiInvestement * 100) / 100;
		}
		throw new InvalidMaturityAmountException("The maturity amount must be in the multiple of 10000");

	}

}
