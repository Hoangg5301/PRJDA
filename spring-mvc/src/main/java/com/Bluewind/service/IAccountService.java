package com.Bluewind.service;

import java.util.List;

import com.Bluewind.dto.AccountDTO;

public interface IAccountService {
	List<AccountDTO> findAll();
	AccountDTO findById(Integer id);
	AccountDTO insert(AccountDTO dto);
	AccountDTO update(AccountDTO dto);
	void delete(Integer id);
}
