package com.Bluewind.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bluewind.convert.AccountConvert;
import com.Bluewind.dto.AccountDTO;
import com.Bluewind.entity.AccountEntity;
import com.Bluewind.repository.AccountRepository;
import com.Bluewind.service.IAccountService;

@Service
public class AccountService implements IAccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountConvert accountConvert;
	
	@Override
	public List<AccountDTO> findAll() {
		List<AccountDTO> listAccountDTO = new ArrayList<>();
		List<AccountEntity> listAccountEntity = accountRepository.findAll();
		for(AccountEntity item : listAccountEntity ) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO = accountConvert.toDTO(item);
			listAccountDTO.add(accountDTO);
		}
		return listAccountDTO;
	}

	@Override
	public AccountDTO findById(Integer id) {
		AccountEntity accountEntity = accountRepository.findOne(id);
		return accountConvert.toDTO(accountEntity);
	}

	@Override
	public AccountDTO insert(AccountDTO dto) {
		AccountEntity accountEntity = accountConvert.toEntity(dto);
		accountEntity = accountRepository.save(accountEntity);
		return accountConvert.toDTO(accountEntity);
	}

	@Override
	public AccountDTO update(AccountDTO dto) {
		AccountEntity accountEntity = accountRepository.findOne(dto.getAccountID());
		accountEntity = accountConvert.toEntity(dto, accountEntity);
		return accountConvert.toDTO(accountRepository.save(accountEntity));
	}

	@Override
	public void delete(Integer id) {
		accountRepository.delete(id);
	}
	
}
