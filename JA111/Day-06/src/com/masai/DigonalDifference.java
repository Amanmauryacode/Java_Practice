package com.masai;

import java.util.Scanner;

public class DigonalDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size of the matrix:");
		int n= sc.nextInt();
		System.out.println("Enter elements of matrix:");
		
		int[][] arr = new int[n][n];
		
		for(int i =0;i<n;i++) {
			for (int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int digonalSum1 = 0;
		int digonalSum2 = 0;
		
		for(int i=0;i<n;i++) {
			digonalSum1+=arr[i][i];
			digonalSum2+=arr[n-i-1][i];
		}
		System.out.println("The difference of sum of the diagonal is"+(digonalSum1-digonalSum2));
		

	}

}
