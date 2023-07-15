package com.masai.dao;

import javax.persistence.EntityManager;

import com.masai.entity.Post;
import com.masai.entity.Tags;
import com.masai.exception.PostException;
import com.masai.exception.TagsException;
import com.masai.utility.EMUtil;

public class TImeLineDaoImpl implements TimelineDAO {

	@Override
	public void addPost(Post post) {
		EntityManager em = EMUtil.provideEntityManager();
		Post p = em.find(Post.class, post.getPostId());
		if(p != null)throw new PostException("Post Already Exist ");
		
		em.getTransaction().begin();
		em.persist(post);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Post getPost(int postId) {
		EntityManager em = EMUtil.provideEntityManager();
		Post p = em.find(Post.class, postId);
		if(p == null)throw new PostException("Post not found! ");
		
		return p;
	}

	@Override
	public Tags getTags(int tagId) {
		EntityManager em = EMUtil.provideEntityManager();
		Tags tag = em.find(Tags.class, tagId);
		if(tag == null)throw new TagsException("Post not found! ");
		
		return tag;
		
	}

}
