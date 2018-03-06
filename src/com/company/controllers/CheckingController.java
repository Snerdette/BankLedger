package com.company.controllers;

import com.company.entities.Checking;

public class CheckingController {


    public double deposit(double balance){
       System.out.println("Deposit made, your new balance is $" + balance);


        Checking.updateBalance(balance);

        return balance;
    }


}
