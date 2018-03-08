package com.company.entities;

import java.util.ArrayList;
import java.util.List;

public class Checking {

    int id;
    static double balance;
    public static ArrayList<Transaction> transactions;


    public Checking(User currentUser, int transactionsId){
        this.id = currentUser.getId();
        this.balance = 0.00;
        this.transactions = new ArrayList<Transaction>();
        Transaction newTransaction = new Transaction(balance, "New Account", currentUser, transactionsId);
        this.transactions.add(newTransaction);

        System.out.println("Checking account made for user ID: " + id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Double getBalance() {
        return balance;
    }

    public static void setBalance(Double balance) {
        Checking.balance = balance;
    }

    public void setTransactions(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public static ArrayList<Transaction> getTransactions(){
        return transactions;
    }


}
