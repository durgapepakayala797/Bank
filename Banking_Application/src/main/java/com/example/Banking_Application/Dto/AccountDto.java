package com.example.Banking_Application.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
public class AccountDto {
	private int id;
	private String accountHolderName;
	private double balance;
}
