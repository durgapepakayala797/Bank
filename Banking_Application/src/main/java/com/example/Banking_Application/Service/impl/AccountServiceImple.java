package com.example.Banking_Application.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Banking_Application.Dto.AccountDto;
import com.example.Banking_Application.Entity.Account;
import com.example.Banking_Application.Mapper.AccountMapper;
import com.example.Banking_Application.Repository.AccountRepo;
import com.example.Banking_Application.Service.AccountService;
@Service
public class AccountServiceImple implements AccountService {
	@Autowired
	private AccountRepo repo;
	
	
	public AccountServiceImple(AccountRepo repo) {
		super();
		this.repo = repo;
	}
	@Override
	
	
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=repo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	public AccountDto getAccountById(int id) {
		Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}
	@Override
	public AccountDto deposit(int id, double amount) {
		// TODO Auto-generated method stub
		Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		double totalAmount = account.getBalance()+ amount;
		account.setBalance(totalAmount);
		Account savedAccount=repo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	@Override
	public AccountDto withdraw(int id, double amount) {
		// TODO Auto-generated method stub
		Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("insufficient funds");
		}
		double total=account.getBalance()- amount;
		account.setBalance(total);
		Account savedAccount = repo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts=repo.findAll();
		return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		 
	}
	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		repo.deleteById(id);
	}
	

}
