package com.masai.eval.problem1;

interface Intr1{
	Product productObj(String str);
}
interface Intr2{
	Product get();
}
interface Intr3{
	void print(Product p1 );
}
interface Intr4{
	boolean test(Product p1);
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Intr1 i1 = s->{
			String[] arr = s.split(",");
			Product product = new Product(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
			
			return product;
		};
		Product p1 = i1.productObj("1,Soap,50,100");
		System.out.println(p1);
		
		Intr2 i2 = ()-> i1.productObj("1,Popcon,10,4");
		System.out.println(i2.get());
		
		Intr3 i3 = p-> System.out.println(p);
		i3.print(p1);
		
		Intr4 i4 = p-> p.getQuantity() <5 ;
		System.out.println(i4.test(i2.get()));
		
	}

}
