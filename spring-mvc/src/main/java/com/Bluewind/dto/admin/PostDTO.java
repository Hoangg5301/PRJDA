package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class PostDTO extends AbstractDTO<PostDTO>{
	private Integer postID;
	private String postName;
	private String postContent;
	private Integer accountID;
	
	
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Integer getAccountID() {
		return accountID;
	}
	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}
	
	
}
