package org.practice.bankmanagement.service;

import org.practice.bankmanagement.entity.Account;

import java.util.List;

public interface AccountService {

   public Account createAccount(Account account);

   public Account getAccountDetails(Long accountNumber);

   public List<Account> getAllAccountDetails();

   public Account deposit(Long accountNumber, Double amount);

   public Account withdraw(Long accountNumber, Double amount);

   public void closeAccount(Long accountNumber);

}
