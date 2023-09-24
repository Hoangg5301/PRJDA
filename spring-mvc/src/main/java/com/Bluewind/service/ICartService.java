package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.admin.CartDTO;

public interface ICartService {
	List<CartDTO> findAll();
	CartDTO findById(Integer id);
	CartDTO insert(CartDTO dto);
	CartDTO update(CartDTO dto);
	void delete(Integer id);
}
