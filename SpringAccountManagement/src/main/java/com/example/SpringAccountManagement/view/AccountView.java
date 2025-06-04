package com.example.SpringAccountManagement.view;

import com.example.SpringAccountManagement.model.Account;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private Scanner scanner;

    public AccountView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== Account Management System ===");
        System.out.println("1. Add Account");
        System.out.println("2. Update Account");
        System.out.println("3. Delete Account");
        System.out.println("4. Display All Accounts");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public String[] getAccountInput() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }

    public int getAccountId() {
        System.out.print("Enter account ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayAccounts(List<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\nList of Accounts:");
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}