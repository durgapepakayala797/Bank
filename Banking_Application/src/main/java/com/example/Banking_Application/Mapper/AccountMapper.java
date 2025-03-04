package com.example.Banking_Application.Mapper;

import com.example.Banking_Application.Dto.AccountDto;
import com.example.Banking_Application.Entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account=new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()
				);
		return account;
		
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto(account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountDto;
	}
	
}

