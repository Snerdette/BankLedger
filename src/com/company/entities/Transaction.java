package com.company.entities;

public class Transaction {

    int id;
    double amount;
    String action;

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

    public String getAction(){
        return action;
    }

    public void setAction(){
        this.action = action;
    }

}
