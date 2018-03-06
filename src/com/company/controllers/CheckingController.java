package com.company.controllers;

import com.company.entities.Checking;

import static com.company.entities.Checking.getBalance;

public class CheckingController {


    public static double updateBalance(double amount, String type){
        double balance = getBalance();

        if(type.equals("withdraw")){
            System.out.println("Making a withdrawl of " + amount + " from the current balance of: " + balance);
            balance = balance - amount;
            System.out.println("new balance: " + balance);
        }
        else if(type.equals("deposit")){
            System.out.println("Making a deposit of " + amount + " from the current balance of: " + balance);
            balance = amount + balance;
            System.out.println("new balance: " + balance);
        } else {
            System.out.println("Error in transaction type");
        }

        Checking.setBalance(balance);

        return balance;
    }


}
