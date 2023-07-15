package com.masai.usecase;

import com.masai.dao.TImeLineDaoImpl;
import com.masai.dao.TimelineDAO;
import com.masai.entity.Post;

public class GetPost {

	public static void main(String[] args) {
		TimelineDAO dao = new TImeLineDaoImpl();
		
		try {
			Post p = dao.getPost(1);
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
