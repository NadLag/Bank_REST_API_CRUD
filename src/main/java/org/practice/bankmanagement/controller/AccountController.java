package org.practice.bankmanagement.controller;

import org.practice.bankmanagement.entity.Account;
import org.practice.bankmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

   @Autowired
   private AccountService accountService;

   @PostMapping("/add")
   public ResponseEntity<Account> createAccount(@RequestBody Account account) {
      Account createdAccount = accountService.createAccount(account);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
   }

   @GetMapping("/details/{id}")
   public ResponseEntity<Account> getAccountById(@PathVariable long id) {
      Account accountDetails = accountService.getAccountDetails(id);
      return ResponseEntity.status(HttpStatus.OK).body(accountDetails);

   }

   @GetMapping("/getallaccounts")
   public ResponseEntity<List<Account>> getAllAccounts() {
      List<Account> allAccountDetails = accountService.getAllAccountDetails();
      return ResponseEntity.status(HttpStatus.OK).body(allAccountDetails);
   }

   @PutMapping("/deposit/{accountNumber}/{amount}")
   public Account deposit(@PathVariable long accountNumber, @PathVariable double amount) {
      return accountService.deposit(accountNumber, amount);
   }

   @PutMapping("/withdraw/{accountNumber}/{amount}")
   public Account withdraw(@PathVariable long accountNumber, @PathVariable double amount) {
      return accountService.withdraw(accountNumber, amount);
   }

   @DeleteMapping("/delete/{accountNumber}")
   public ResponseEntity<String> deleteAccount(@PathVariable long accountNumber) {
      accountService.closeAccount(accountNumber);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account deleted successfully");
   }


}
