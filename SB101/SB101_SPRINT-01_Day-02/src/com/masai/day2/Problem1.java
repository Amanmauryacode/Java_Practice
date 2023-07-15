package com.masai.day2;


interface Demo{
	public int convetStringToNumber(String s);
}
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = Integer::parseInt;
		System.out.println(d.convetStringToNumber("10"));

	}

}
