package org.practice.bankmanagement.service;

import org.practice.bankmanagement.entity.Account;
import org.practice.bankmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
   private AccountRepository accountRepository;

   @Override
   public Account createAccount(Account account) {
      return accountRepository.save(account);
   }

   @Override
   public Account getAccountDetails(Long accountNumber) {
      Optional<Account> account = accountRepository.findById(accountNumber);
      if (account.isEmpty()) {
         throw new RuntimeException("Account not found");
      }
      return account.get();
   }

   @Override
   public List<Account> getAllAccountDetails() {
      return accountRepository.findAll();
   }

   @Override
   public Account deposit(Long accountNumber, Double amount) {
      Optional<Account> account = accountRepository.findById(accountNumber);
      if (account.isEmpty()) {
         throw new RuntimeException("Account not found");
      }
      Account isPresentAccount = account.get();
      isPresentAccount.setAmount(isPresentAccount.getAmount() + amount);
      return accountRepository.save(isPresentAccount);
   }

   @Override
   public Account withdraw(Long accountNumber, Double amount) {
      Optional<Account> account = accountRepository.findById(accountNumber);
      if (account.isEmpty()) {
         throw new RuntimeException("Account not found");
      }
      Account isPresentAccount = account.get();
      isPresentAccount.setAmount(isPresentAccount.getAmount() - amount);
      return accountRepository.save(isPresentAccount);
   }

   @Override
   public void closeAccount(Long accountNumber) {
      getAccountDetails(accountNumber);
      accountRepository.deleteById(accountNumber);
   }
}
