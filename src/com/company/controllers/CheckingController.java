package com.company.controllers;

import com.company.entities.Checking;
import com.company.entities.Checking.*;
import com.company.entities.Transaction;
import com.company.entities.User;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CheckingController {


    public static double updateBalance(double amount, String type, User currentUser){

        double balance = getBalanceForUser(currentUser);
        DecimalFormat dec = new DecimalFormat("#0.00");
        System.out.println("Starting balance before update: $" + dec.format(balance));
        Checking checking = currentUser.getChecking();

        if(type.equals("withdraw")){
            System.out.println("Making a withdrawl of " + amount + " from the current balance of: " + dec.format(balance));
            balance = balance - amount;
            System.out.println("new balance: " + dec.format(balance));
        }
        else if(type.equals("deposit")){
            System.out.println("Making a deposit of " + dec.format(amount) + " from the current balance of: " + dec.format(balance));
            balance = amount + balance;
            System.out.println("new balance: " + dec.format(balance));
        } else if(type.equals("New Account")){
            System.out.println("Welcome! Your New Checking Account has been created!");
        } else {
            System.out.println("Error in transaction type");
        }

        checking.setBalance(balance);

        Transaction thisTransaction = new Transaction(amount, type, currentUser);

        if(checking.getTransactions() != null){
            checking.getTransactions().add(thisTransaction);
        }

        return balance;
    }

    public static double getBalanceForUser(User currentUser){

        Checking checking = currentUser.getChecking();
        double balance = checking.getBalance();

        System.out.println("Returning balance of: $" + balance + " for " + currentUser.getUsername());
        return balance;
    }

    public void addAccounts(User currentUser) {
        //Checking.accounts;

        //accounts.add(currentUser.getChecking());
    }
}
