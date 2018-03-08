package com.company.controllers;

import com.company.entities.Checking;
import com.company.entities.Transaction;
import com.company.entities.User;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TransactionController {

    static DecimalFormat dec = new DecimalFormat("#0.00");

    public static void printAllTransactions(User currentUser){
        Checking checking = currentUser.getChecking();
        ArrayList<Transaction> transactions = checking.getTransactions();

        System.out.println("Transactions for User " + currentUser.getUsername());

        for(Transaction transaction : transactions){

            if(transaction.getUser() == currentUser){
                System.out.println("ID: " + transaction.getId() +
                        " Type: " + transaction.getType() +
                        " Amount: $ " + dec.format(transaction.getAmount()));
            } else {
                System.out.println("No Transactions for username: " + currentUser.getUsername());
            }

        }
    }
}
