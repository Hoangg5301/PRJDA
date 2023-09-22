package com.Bluewind.dto.admin;

import com.Bluewind.dto.AbstractDTO;

public class PostDTO extends AbstractDTO<PostDTO>{
	private String postName;
	private String postContent;
	private int idTK;
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
	public int getIdTK() {
		return idTK;
	}
	public void setIdTK(int idTK) {
		this.idTK = idTK;
	}
	
	
}
