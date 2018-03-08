package com.company.entities;

import java.util.ArrayList;

public class Checking {

    int id;
    double balance;
    public ArrayList<Transaction> transactions;
    public ArrayList<Checking> accounts;


    public Checking(User currentUser){
        this.id = currentUser.getId();
        this.balance = 0.00;
        this.transactions = new ArrayList<Transaction>();
        Transaction newTransaction = new Transaction(balance, "New Account", currentUser);
        this.transactions.add(newTransaction);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setTransactions(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public ArrayList<Checking> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Checking> accounts) {
        this.accounts = accounts;
    }
}
