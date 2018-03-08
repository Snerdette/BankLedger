// Kathryn LaFrance
//Bank Ledger
//

package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

import com.company.entities.Checking;
import com.company.entities.User;

import static com.company.controllers.UserController.*;
import static com.company.entities.User.numOfUsers;

import com.company.controllers.CheckingController;
import com.company.controllers.TransactionController;


public class Main {

    static ArrayList<User> userList = new ArrayList<User>();

    boolean exit = false; //Used for exciting the menu.

    static User currentUser;

    public static void main(String[] args) {

        Main main = new Main();

        if(currentUser == null){
            System.out.println("Entering Login Menu");
            main.runLoginMenu();
        } else {
            System.out.println("Entering User Menu");
            //main.runUserMenu();
        }

    }

    public void runLoginMenu(){

        int choice = -1;
        Scanner input = new Scanner(System.in);
        currentUser = null;

        System.out.println("*---------------------------------------------------*");
        System.out.println("|            Welcome the our bank!                  |");
        System.out.println("*---------------------------------------------------*");
        System.out.println("*            Enter (0) to Exit                     *");
        System.out.println("*            Enter (1) to Login                     *");
        System.out.println("*            Enter (2) to Register a new user       *");
        System.out.println("*---------------------------------------------------*");
        System.out.println("\nEnter Choice: ");

        choice = input.nextInt();

        do {
            switch (choice) {
                case 0:
                    System.out.println("Thank you for visiting our Bank, Please com again (^_^)");
                    break;
                case 1:
                    currentUser = loginUser(numOfUsers, userList, currentUser);
                    if(currentUser == null){
                        runLoginMenu();
                    }
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 2:
                    System.out.println("Registering new user..");
                    currentUser = newUser(numOfUsers, userList);
                    //CheckingController.addAccounts(currentUser);
                    input.nextLine();
                    System.out.println("Done registering new user!");
                    choice = 4;
                    runUserMenu(currentUser);
                    break;
                default:
                    System.out.println("Default case selected");
            }
            input.nextLine();
        } while (choice != 0);
    }

    public void runUserMenu(User currentUser){
        Checking checking = currentUser.getChecking();
        int choice = -1;
        Scanner input = new Scanner(System.in);
        double amount = 0.00;
        double balance = checking.getBalance();

        DecimalFormat dec = new DecimalFormat("#0.00");

        System.out.println("*---------------------------------------------------*");
        System.out.println("|            "+currentUser.getUsername()+"                  |");
        System.out.println("|            Welcome the our bank!                  |");
        System.out.println("*---------------------------------------------------*");
        System.out.println("*---------------------------------------------------*");
        System.out.println("*     Enter (0) to Exit                             *");
        System.out.println("*     Enter (1) to Make a Deposit                   *");
        System.out.println("*     Enter (2) to Make a Withdrawal                *");
        System.out.println("*     Enter (3) to See Transaction History          *");
        System.out.println("*     Enter (4) to Logout & return to main menu     *");
        System.out.println("*---------------------------------------------------*");
        System.out.println("Your current balance is: $" + dec.format(balance));
        System.out.println("\nEnter Choice: ");
        System.out.println();

        choice = input.nextInt();

        do {
            switch (choice) {
                case 0:
                    System.out.println("Thank you for visiting our Bank, Please come again (^_^)");
                    break;
                case 1:
                    System.out.println("How Much would you like to deposit?");
                    amount = input.nextDouble();
                    //balance = balance + amount;

                    CheckingController.updateBalance(amount, "deposit", currentUser);
                    input.nextLine();
                    amount = 0.00;
                    runUserMenu(currentUser);
                    break;
                case 2:
                    System.out.println("How Much would you like to withdraw?");
                    amount = input.nextDouble();
                    CheckingController.updateBalance(amount, "withdraw", currentUser);
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 3:
                    TransactionController.printAllTransactions(currentUser);
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 4:
                    currentUser = null;
                    //System.out.println("Current User on logout: " + currentUser.getUsername());
                    runLoginMenu();
                    break;
                default:
                    System.out.println("Default case selected");
            }
            input.nextLine();
        } while (choice != 0);
    }
}
