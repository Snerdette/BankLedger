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

        System.out.println("Transactions for " + currentUser.getUsername());
        System.out.printf( "%4s%-15s%8s\n", "ID: ", " Type: ", " Amount:");

        for(Transaction transaction : transactions){

            if(transaction.getUser() == currentUser){
                System.out.printf( "%-5s%-12s%10s\n", transaction.getId(), transaction.getType(), dec.format(transaction.getAmount()));
            } else {
                System.out.println("No transactions for: " + currentUser.getUsername());
            }

        }
    }
}
