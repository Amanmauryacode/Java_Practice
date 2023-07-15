package com.masai.problem4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

public class BallOperationsByRyan {
	
	
	static Map<String, List<BallOfOver>> getScoreList() throws IOException, Exception{
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("score.ser"));
		Map<String, List<BallOfOver>> map = (Map<String, List<BallOfOver>>)ois.readObject();
		
		ois.close();
		
		return map;
		
	}
	
	static String findWinner(Map<String, List<BallOfOver>> map) {
		
		List<BallOfOver> list1 = map.get("Team-A");
		List<BallOfOver> list2 = map.get("Team-B");
		int score1 = 0;
		
		for(int i=0;i<list1.size();i++) {
			score1+= list1.get(i).getRun();
		}
		
		int score2 = 0;
		
		for(int i=0;i<list2.size();i++) {
			score2+= list2.get(i).getRun();
		}
		
		if(score1 == score2) {
			return "Match Tied Finally";
		}else if(score1 > score2) {
			return "Team-A won by "+(score1-score2)+" runs"; 
		}else {
			return "Team-B won by "+(score2-score1)+" runs"; 
		}
		
	}
}
