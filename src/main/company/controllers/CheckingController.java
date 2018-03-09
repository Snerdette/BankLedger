package main.company.controllers;

import main.company.entities.Checking;
import main.company.entities.Transaction;
import main.company.entities.User;

import java.text.DecimalFormat;

public class CheckingController {


    public double updateBalance(double amount, String type, User currentUser){

        double balance = getBalanceForUser(currentUser);
        DecimalFormat dec = new DecimalFormat("#0.00");
        Checking checking = currentUser.getChecking();

        if(type.equals("Withdrawal")){
            System.out.println("Making a withdrawal of " + amount + " from the current balance of: " + dec.format(balance));
            balance = balance - amount;
        }
        else if(type.equals("Deposit")){
            System.out.println("Making a deposit of " + dec.format(amount) + " from the current balance of: " + dec.format(balance));
            balance = amount + balance;
            System.out.println("New balance: " + dec.format(balance));
        } else if(type.equals("New Account")){
            System.out.println("Welcome! Your New Checking Account has been created!");
        } else {
            System.out.println("Error in transaction type");
        }

        checking.setBalance(balance);

        Transaction thisTransaction = new Transaction(amount, type, currentUser);

        if(checking.getTransactions() != null){
            checking.getTransactions().add(thisTransaction);
        }

        return balance;
    }

    public double getBalanceForUser(User currentUser){

        Checking checking = currentUser.getChecking();
        double balance = checking.getBalance();

        return balance;
    }

}
