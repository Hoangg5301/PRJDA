package com.Bluewind.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bluewind.dto.AccountDTO;
import com.Bluewind.service.IAccountService;

@RestController(value = "AccountAPI")
public class AccountAPI {
	@Autowired
	private IAccountService accountService;
	
	@PostMapping("/api/account")
	public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
		return accountService.insert(accountDTO);
	}
	@PutMapping("/api/account")
	public AccountDTO updateAccount(@RequestBody AccountDTO accountDTO) {
		return accountService.update(accountDTO);
	}
	@DeleteMapping("/api/account")
	public void deleteAccount(@RequestBody Integer idAccount) {
		accountService.delete(idAccount);
	}
}
