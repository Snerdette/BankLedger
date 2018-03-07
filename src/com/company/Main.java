// Kathryn LaFrance
//Bank Ledger
//

package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.text.DecimalFormat;

import com.company.controllers.CheckingController;
import com.company.entities.Checking;
import com.company.entities.User;
import com.company.services.UserService;

import static com.company.controllers.UserController.*;
import static com.company.controllers.CheckingController.*;
import static com.company.entities.Checking.*;
import static com.company.entities.Checking.getBalance;
import static javafx.application.Platform.exit;



public class Main {


    static ArrayList<User> userList = new ArrayList<User>();

    static int numOfUsers = 0; //Used to set user ID's

    static int transactionsId = 0;

    boolean exit = false; //Used for exciting the menu.

    static int currentUserID = 0;//Currently Logged in user's ID.

    static User currentUser;

    public static void main(String[] args) {

        Main main = new Main();

        if(currentUser == null){
            System.out.println("Entering Login Menu");
            main.runLoginMenu(currentUser);
        } else {
            System.out.println("Entering User Menu");
            //main.runUserMenu();
        }


    }

    public void runLoginMenu(User currentUser){

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
                        runLoginMenu(currentUser);
                    }
                    runUserMenu(currentUser);
                    break;
                case 2:
                    System.out.println("Registering new user..");
                    currentUser = newUser(numOfUsers, userList);
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

        int choice = -1;
        Scanner input = new Scanner(System.in);
        double balance = getBalance();
        double amount = 0.00;

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
        System.out.println("*     Enter (3) to Logout & return to main menu     *");
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

                    CheckingController.updateBalance(amount, "deposit");
                    input.nextLine();
                    amount = 0.00;
                    runUserMenu(currentUser);
                    break;
                case 2:
                    System.out.println("How Much would you like to withdraw?");
                    amount = input.nextDouble();
                    CheckingController.updateBalance(amount, "withdraw");
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 3:
                    currentUser = null;
                    runLoginMenu(currentUser);
                    break;
                default:
                    System.out.println("Default case selected");
            }
            input.nextLine();
        } while (choice != 0);
    }
}
