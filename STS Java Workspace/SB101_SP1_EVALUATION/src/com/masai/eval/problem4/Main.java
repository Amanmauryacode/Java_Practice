package com.masai.eval.problem4;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(16);
		list1.add(16);
		list1.add(20);
		list1.add(25);
		list1.add(17);
		list1.add(18);
		list1.add(55);
		list1.add(45);
		list1.add(24);
		list1.add(33);
		
		if(list1.stream().allMatch(age->age>=18)) {
			System.out.println("You all can cast your vote");
		}else {
			System.out.println( "Some or none will cast vote");
		}
		
		list1.stream().distinct().forEach(age->System.out.println(age));
		
		List<Integer> list2 = list1.stream().sorted((a1,a2)->a1-a2).collect(Collectors.toList());
	
		for(int i=5;i<8;i++) {
			System.out.println(list2.get(i));
		}
		System.out.println(list1.stream().reduce(0,(a1,a2)->a1+a2));
		
		
//		5.1 The BinaryOperator interface is a subinterface of the Function interface such that both are SAM interfaces.
//		true;
//		5.2 The BiConsumer interface is a subinterface of the Consumer interface such that both are SAM interfaces.
//		true;
		
	}

}
