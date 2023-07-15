package com.masai.usecase;

import com.masai.dao.TImeLineDaoImpl;
import com.masai.dao.TimelineDAO;
import com.masai.entity.Tags;

public class GetTags {

	public static void main(String[] args) {
TimelineDAO dao = new TImeLineDaoImpl();
		
		try {
			Tags t = dao.getTags(1);
			System.out.println(t);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
