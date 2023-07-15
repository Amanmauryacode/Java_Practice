package com.masai.problem4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BallOperationsByNitin {

	
	static void recordScores(List<BallOfOver> scoreList, Scanner sc) {
		System.out.print("Enter run scored on this ball : ");
		int score = sc.nextInt();
		System.out.print("Is it a valid ball (y/n) : ");
		char isValidBall =  sc.next().charAt(0);
		scoreList.add(new BallOfOver(score,isValidBall ));
	}
	
	static void saveScores(Map<String, List<BallOfOver>> over)throws IOException  {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("score.ser"));
		oos.writeObject(over);
		oos.close();
	}

	
}
