package com.company.controllers;

import com.company.entities.Checking;

import java.text.DecimalFormat;

import static com.company.entities.Checking.getBalance;

public class CheckingController {


    public static double updateBalance(double amount, String type){
        double balance = getBalance();
        DecimalFormat dec = new DecimalFormat("#0.00");

        if(type.equals("withdraw")){
            System.out.println("Making a withdrawl of " + amount + " from the current balance of: " + dec.format(balance));
            balance = balance - amount;
            System.out.println("new balance: " + dec.format(balance));
        }
        else if(type.equals("deposit")){
            System.out.println("Making a deposit of " + dec.format(amount) + " from the current balance of: " + dec.format(balance));
            balance = amount + balance;
            System.out.println("new balance: " + dec.format(balance));
        } else {
            System.out.println("Error in transaction type");
        }

        Checking.setBalance(balance);

        return balance;
    }


}
