package com.example.SpringAccountManagement.model;

import java.util.ArrayList;
import java.util.List;
public class AccountModel {
    private List<Account> accounts;
    private int nextId;

    public AccountModel() {
        accounts = new ArrayList<>();
        nextId = 1;
    }

    public Account addAccount(Account account) {
        account.setId(nextId++);
        accounts.add(account);
        return account;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Account findAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public Account updateAccount(int id, Account updatedAccount) {
        Account account = findAccountById(id);
        if (account != null) {
            account.setUsername(updatedAccount.getUsername());
            account.setPassword(updatedAccount.getPassword());
            return account;
        }
        return null;
    }

    public boolean deleteAccount(int id) {
        Account account = findAccountById(id);
        if (account != null) {
            accounts.remove(account);
            return true;
        }
        return false;
    }
}