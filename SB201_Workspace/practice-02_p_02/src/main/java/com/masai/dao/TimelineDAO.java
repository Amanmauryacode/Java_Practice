package com.masai.dao;

import com.masai.entity.Post;
import com.masai.entity.Tags;

public interface TimelineDAO {
	public void addPost(Post post);

	public Post getPost(int postId);

	public Tags getTags(int tagId);
}
