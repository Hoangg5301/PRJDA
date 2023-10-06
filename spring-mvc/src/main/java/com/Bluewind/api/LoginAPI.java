package com.Bluewind.api;

import com.Bluewind.dto.AccountDTO;
import com.Bluewind.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "LoginAPI")
public class LoginAPI {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/api/login")
    public AccountDTO checkAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.checkLogin(accountDTO.getUserName(), accountDTO.getPassword());
    }
}
