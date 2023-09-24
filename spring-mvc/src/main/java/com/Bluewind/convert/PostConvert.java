package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.admin.PostDTO;
import com.Bluewind.entity.PostEntity;

@Component
public class PostConvert {
	public PostDTO toDTO(PostEntity postEntity) {
		PostDTO postDTO = new PostDTO();
		postDTO.setPostID(postEntity.getPostID());
		postDTO.setPostName(postEntity.getPostName());
		postDTO.setPostContent(postEntity.getPostContent());
		postDTO.setAccountID(postEntity.getAccountID());
		return postDTO;
	}
	
	
	public PostEntity  toEntity(PostDTO postDTO) {
		PostEntity postEntity  = new PostEntity();

		postEntity.setPostName(postDTO.getPostName());
		postEntity.setPostContent(postDTO.getPostContent());
		postEntity.setAccountID(postDTO.getAccountID());
		return postEntity;
	}
	
	public PostEntity toEntity(PostDTO postDTO, PostEntity oldEntity) {
		oldEntity.setPostName(postDTO.getPostName());
		oldEntity.setPostContent(postDTO.getPostContent());
		oldEntity.setAccountID(postDTO.getAccountID());
		return oldEntity;
	}
}
