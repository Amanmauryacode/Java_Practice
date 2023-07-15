package com.masai.problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SerializationDemo {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		List<BallOfOver> list1 = new ArrayList<>();
		int Team_1_ballCount=0;
		System.out.println("Enter ball by ball score for Team-A");
		System.out.println("------------------------------------------------------");
		while(Team_1_ballCount !=6) {
			
			BallOperationsByNitin.recordScores(list1, sc);
			Team_1_ballCount = (int) list1.stream().filter(l-> l.getIsFairDelivery()=='y').count();
			
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Enter ball by ball score for Team-B");
		
		List<BallOfOver> list2 = new ArrayList<>();
		int Team_2_ballCount=0;
		
		while(Team_2_ballCount !=6) {
			
			BallOperationsByNitin.recordScores(list2, sc);
			Team_2_ballCount = (int) list2.stream().filter(l-> l.getIsFairDelivery()=='y').count();
			
		}
		
		Map<String,List<BallOfOver>> map = new HashMap<>();
		
		map.put("Team-A", list1);
		map.put("Team-B", list2);
		BallOperationsByNitin.saveScores(map);
		System.out.println("------------------------------------------------------");
		System.out.println("Scored Recorded...");
		
		
		System.out.println(BallOperationsByRyan.findWinner(BallOperationsByRyan.getScoreList()));
		System.out.println("Bye Bye...");
		

	}

}
