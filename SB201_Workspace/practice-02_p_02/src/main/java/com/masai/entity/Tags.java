package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tagId")
	private int tagId;
    private String tagName;
    
    @ManyToMany(mappedBy = "tagsList",cascade = CascadeType.PERSIST)
    List<Post> postList = new ArrayList<>();

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	@Override
	public String toString() {
		return "Tags [tagId=" + tagId + ", tagName=" + tagName +"]";
	}
    
    
    
    
}
