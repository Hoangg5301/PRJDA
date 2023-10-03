package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bluewind.convert.PostConvert;
import com.Bluewind.dto.admin.PostDTO;
import com.Bluewind.entity.PostEntity;
import com.Bluewind.repository.PostRepository;
import com.Bluewind.service.IPostService;

@Service
public class PostService implements IPostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private PostConvert postConvert;
	
	@Override
	public PostDTO findAll() {
		List<PostDTO> listPostDTO = new ArrayList<>();
		List<PostEntity> listPostEntity = postRepository.findAll();
		for(PostEntity postEntity : listPostEntity) {
			listPostDTO.add(postConvert.toDTO(postEntity));
		}
		PostDTO postDTO = new PostDTO();
		postDTO.setListResult(listPostDTO);
		return postDTO;
	}

	@Override
	public PostDTO findById(Integer id) {
		return postConvert.toDTO(postRepository.findOne(id));
	}

	@Override
	@Transactional
	public PostDTO insert(PostDTO dto) {
		PostEntity postEntity = postRepository.save(postConvert.toEntity(dto));
		return postConvert.toDTO(postEntity);
	}

	@Override
	@Transactional
	public PostDTO update(PostDTO dto) {
		PostEntity oldEntity = postRepository.findOne(dto.getPostID());
		oldEntity = postConvert.toEntity(dto, oldEntity);
		return postConvert.toDTO(postRepository.save(oldEntity));
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		postRepository.delete(id);
	}

	@Override
	public List<PostDTO> getList() {
		List<PostDTO> postDTOS = new ArrayList<>();
		List<PostEntity> postEntities = postRepository.findTop3ByOrderByPostID();
		for (PostEntity p : postEntities) {
			postDTOS.add(postConvert.toDTO(p));
		}
		return postDTOS;
	}

}
