package com.masai.usecase;

import java.time.LocalDateTime;

import com.masai.dao.TImeLineDaoImpl;
import com.masai.dao.TimelineDAO;
import com.masai.entity.Post;
import com.masai.entity.Tags;

public class AddPost {

	public static void main(String[] args) {
		Post post = new Post();
		
		post.setDescription("Hello");
		post.setLastUpdatedAt(LocalDateTime.now());
		post.setPostedAt(LocalDateTime.now());
		post.setTitle("First Post");
		
		Tags tag = new Tags();
		tag.setTagName("Aman");
		tag.getPostList().add(post);
		
		Tags tag1 = new Tags();
		tag1.setTagName("Anuj");
		tag1.getPostList().add(post);
		
		Tags tag2 = new Tags();
		tag2.setTagName("Pradyum");
		tag2.getPostList().add(post);
		
		Tags tag3 = new Tags();
		tag3.setTagName("Sahil");
		tag3.getPostList().add(post);
		
		post.getTagsList().add(tag);
		post.getTagsList().add(tag1);
		post.getTagsList().add(tag2);
		post.getTagsList().add(tag3);
		TimelineDAO dao = new TImeLineDaoImpl();
		
		try {
			dao.addPost(post);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Done..");
		
	}
}
