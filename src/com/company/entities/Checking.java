package com.company.entities;

public class Checking {

    int id;
    double balance;
    int transactions[][];

    Checking(){};

    public Checking(int id){
        this.id = id;
        this.balance = 0.00;

        System.out.println("Checking account made for user ID: " + id);
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
}
