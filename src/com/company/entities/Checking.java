package com.company.entities;

import java.util.List;

public class Checking {

    int id;
    static double balance;
    List<Transaction> transactions;


    public Checking(int id){
        this.id = id;
        this.balance = 0.00;
        this.transactions = transactions;

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

    public void setTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }


}
