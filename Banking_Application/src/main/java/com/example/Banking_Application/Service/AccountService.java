package com.example.Banking_Application.Service;

import java.util.List;

import com.example.Banking_Application.Dto.AccountDto;

public interface AccountService {
	AccountDto createAccount (AccountDto accountDto);
	
	AccountDto getAccountById(int id);
	
	AccountDto deposit(int id,double amount);
	
	AccountDto withdraw(int id,double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(int id);
}
