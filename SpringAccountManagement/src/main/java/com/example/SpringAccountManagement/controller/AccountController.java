package com.example.SpringAccountManagement.controller;

import com.example.SpringAccountManagement.model.Account;
import com.example.SpringAccountManagement.model.AccountModel;
import com.example.SpringAccountManagement.view.AccountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountModel accountModel;

    @Autowired
    public AccountController(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountModel.getAllAccounts();
    }

    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return accountModel.addAccount(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
        Account updatedAccount = accountModel.updateAccount(id, account);
        if (updatedAccount != null) {
            return ResponseEntity.ok(updatedAccount);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        if (accountModel.deleteAccount(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}