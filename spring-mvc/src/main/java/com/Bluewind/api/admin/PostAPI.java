package com.Bluewind.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bluewind.dto.admin.PostDTO;
import com.Bluewind.service.IPostService;

@RestController(value = "postAPIOfAdmin")
public class PostAPI {
	@Autowired
	private IPostService postService;
	
	@PostMapping("/api/post")
	public PostDTO createPost(@RequestBody PostDTO postDTO) {
		return postService.insert(postDTO);
	}
	@PutMapping("/api/post")
	public PostDTO updatePost(@RequestBody PostDTO postDTO) {
		return postService.update(postDTO);
	}
	@DeleteMapping("/api/post")
	public void deletePost(@RequestBody Integer idPost) {
		postService.delete(idPost);
	}
}
