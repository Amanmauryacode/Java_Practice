package com.masai.Demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.masai.entity.Player;

public class Demo {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("player");
		EntityManager entitymanager = emfactory.createEntityManager();

		// write your logic here
		// 1. Write a Query That will return the list of player names in Upper case
		// (Scalar function)

		TypedQuery<String> q = entitymanager.createQuery("select UPPER(p.name) from Player p", String.class);

		List<String> s = q.getResultList();

		for (String name : s) {
			System.out.println(name);
		}

		// 2. Write a Query That will give a min age of a player out of all players.
		// (Aggregate function)

		Query q1 = entitymanager.createQuery("select MIN(p.age) from Player p");

		int age = (int) q1.getSingleResult();
		System.out.println(age);

		// 3. Write a Query That will give a list of players with an age group between
		// 18 to 25 years. (Between)

		TypedQuery<Player> q2 = entitymanager.createQuery("select p from Player p where p.age BETWEEN 18 AND 25 ", Player.class);

		List<Player> player = q2.getResultList();
		
		for(Player p : player) {
			System.out.println(p);
		}
		
		
		// 4. Write a Query that will return the name of players whose names start with a particular letter. (Like) 
		
		
		TypedQuery<String> q3 = entitymanager.createQuery("select p.name from Player p WHERE p.name LIKE 'A%' ", String.class);

		List<String> list = q3.getResultList();

		for (String name : list) {
			System.out.println(name);
		}
		
	}
}
