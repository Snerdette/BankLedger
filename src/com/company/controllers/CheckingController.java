package com.company.controllers;

import com.company.entities.Checking;
import com.company.entities.Transaction;
import com.company.entities.User;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.company.entities.Checking.getBalance;

public class CheckingController {


    public static double updateBalance(double amount, String type, int transactionsId, User currentUser){
        double balance = getBalance();
        DecimalFormat dec = new DecimalFormat("#0.00");
        String transactionType = type;


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
            System.out.println("New Checking account has been created.");
        } else {
            System.out.println("Error in transaction type");
        }

        Checking.setBalance(balance);

        Transaction thisTransaction = new Transaction(amount, type, currentUser, transactionsId);
        if(Checking.getTransactions() != null){
            Checking.getTransactions().add(thisTransaction);
        }
        return balance;
    }

    public static void newTransaction(Transaction transaction){

        System.out.println("New Transaction added.");
        System.out.println(Checking.getTransactions());
    }
}
