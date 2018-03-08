package com.company.entities;

import com.company.Main;
import com.company.entities.Checking;
import java.text.DecimalFormat;

import static com.company.entities.Checking.transactions;

public class Transaction {

    int id;
    double amount;
    String type;
    User user;

    public Transaction(){};

    public Transaction(double amount, String type, User user, int transactionsId){
        this.amount = amount;
        this.type = type;
        this.id = id;

        transactionsId++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType(){
        return type;
    }

    public void setType(){
        this.type = type;
    }



}
