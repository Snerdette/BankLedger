package com.company.controllers;

import com.company.entities.Checking;
import com.company.entities.Transaction;
import com.company.entities.User;

import java.text.DecimalFormat;

import static com.company.entities.Checking.transactions;

public class TransactionController {
    static DecimalFormat dec = new DecimalFormat("#0.00");

    public double deposit(double amount){
        double newBalance = 0.00;
        return newBalance;
    }

    public double withdraw(double amount){
        double newBalance = 0.00;

        return newBalance;
    }

    public static void printAllTransactions(User currentUser){
        Checking.getTransactions();
        System.out.println("Transactions for User " + currentUser.getUsername());
        for(Transaction transaction : transactions){
            System.out.println("ID: " + transaction.getId() + " Type: " + transaction.getType() + " Amount: $ " + dec.format(transaction.getAmount()));
        }
    }
}
