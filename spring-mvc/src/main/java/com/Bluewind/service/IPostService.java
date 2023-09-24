package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.PostDTO;

public interface IPostService {
	List<PostDTO> findAll();
	PostDTO findById(Integer id);
	PostDTO insert(PostDTO dto);
	PostDTO update(PostDTO dto);
	void delete(Integer id);
}
