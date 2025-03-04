package com.example.Banking_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking_Application.Entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
