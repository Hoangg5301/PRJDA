package com.Bluewind.convert;

import org.springframework.stereotype.Component;

import com.Bluewind.dto.AccountDTO;
import com.Bluewind.entity.AccountEntity;

@Component
public class AccountConvert {
	public AccountDTO toDTO(AccountEntity accountEntity) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountID(accountEntity.getAccountID());
		accountDTO.setAddress(accountEntity.getAddress());
		accountDTO.setEmail(accountEntity.getEmail());
		accountDTO.setPassword(accountEntity.getPassword());
		accountDTO.setPhoneNumber(accountEntity.getPhoneNumber());
		accountDTO.setRole(accountEntity.getRole());
		accountDTO.setStatus(accountEntity.getStatus());
		accountDTO.setUserName(accountEntity.getUserName());
		return accountDTO;
	}
	
	public AccountEntity toEntity(AccountDTO accountDTO) {
		AccountEntity accountEntity  = new AccountEntity();
	
		accountEntity.setAddress(accountDTO.getAddress());
		accountEntity.setEmail(accountDTO.getEmail());
		accountEntity.setPassword(accountDTO.getPassword());
		accountEntity.setPhoneNumber(accountDTO.getPhoneNumber());
		accountEntity.setRole(accountDTO.getRole());
		accountEntity.setStatus(accountDTO.getStatus());
		accountEntity.setUserName(accountDTO.getUserName());
		return accountEntity;
	}
	
	public AccountEntity toEntity(AccountDTO accountDTO, AccountEntity oldEntity) {
		oldEntity.setAddress(accountDTO.getAddress());
		oldEntity.setEmail(accountDTO.getEmail());
		oldEntity.setPassword(accountDTO.getPassword());
		oldEntity.setPhoneNumber(accountDTO.getPhoneNumber());
		oldEntity.setRole(accountDTO.getRole());
		oldEntity.setStatus(accountDTO.getStatus());
		oldEntity.setUserName(accountDTO.getUserName());
		return oldEntity;
	}
}
