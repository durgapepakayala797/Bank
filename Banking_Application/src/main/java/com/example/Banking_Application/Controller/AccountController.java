package com.example.Banking_Application.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking_Application.Dto.AccountDto;
import com.example.Banking_Application.Service.AccountService;
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable int id){
		AccountDto accountDto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable int id,@RequestBody Map<String, Double> request){
		AccountDto accountDto=accountService.deposit(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable int id,@RequestBody Map<String, Double> req){
		Double amount = req.get("amount");
		AccountDto accountDto=accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountsDto=accountService.getAllAccounts();
		return ResponseEntity.ok(accountsDto);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account successully deleted!");
	}

}
