// Kathryn LaFrance
//Bank Ledger
//

package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import com.company.entities.Checking;
import com.company.entities.User;
import com.company.services.UserService;

import static com.company.controllers.UserController.*;
import static javafx.application.Platform.exit;



public class Main {


    static ArrayList<User> userList = new ArrayList<User>();

    static int numOfUsers = 0; //Used to set user ID's

    boolean exit = false; //Used for exciting the menu.

    static int currentUserID = 0;//Currently Logged in user's ID.

    public static void main(String[] args) {

        Main main = new Main();

        if(currentUserID == 0){
            System.out.println("Entering Login Menu");
            main.runLoginMenu();
        } else {
            System.out.println("Entering User Menu");
            main.runUserMenu();
        }


    }

    public void runLoginMenu(){

        int choice = -1;
        Scanner input = new Scanner(System.in);

        System.out.println("*---------------------------------------------------*");
        System.out.println("|            Welcome the our bank!                  |");
        System.out.println("*---------------------------------------------------*");
        System.out.println("*            Enter (0) to Exit                     *");
        System.out.println("*            Enter (1) to Login                     *");
        System.out.println("*            Enter (2) to Register new users        *");
        System.out.println("*---------------------------------------------------*");
        System.out.println("\nEnter Choice: ");

        choice = input.nextInt();

        do {
            switch (choice) {
                case 0:
                    System.out.println("Thank you for visiting our Bank, Please com again (^_^)");
                    break;
                case 1:
                    currentUserID = loginUser(numOfUsers, userList, currentUserID);
                    break;
                case 2:
                    System.out.println("Registering new user..");
                    newUser(numOfUsers, userList);
                    input.nextLine();
                    System.out.println("Done registering new user!");
                    choice = 4;
                    runUserMenu();
                    break;
                default:
                    System.out.println("Default case selected");
            }
            input.nextLine();
        } while (choice != 0);
    }

    public void runUserMenu(){

        int choice = -1;
        Scanner input = new Scanner(System.in);


        System.out.println("*---------------------------------------------------*");
        System.out.println("|            Welcome the our bank!                  |");
        System.out.println("*---------------------------------------------------*");
        System.out.println("*            Enter (0) to Exit                      *");
        System.out.println("*            Enter (1) to View Balance              *");
        System.out.println("*            Enter (2) to Make a Deposit            *");
        System.out.println("*            Enter (3) to Make a Withdrawal         *");
        System.out.println("*            Enter (4) to See Transaction History   *");
        System.out.println("*---------------------------------------------------*");
        System.out.println("\nEnter Choice: ");

        choice = input.nextInt();

        do {
            switch (choice) {
                case 0:
                    System.out.println("Thank you for visiting our Bank, Please com again (^_^)");
                    break;
                case 1:
                    double balance = Checking.getBalance();
                    break;
                case 2:
                    System.out.println("Registering new user..");
                    newUser(numOfUsers, userList);
                    input.nextLine();
                    System.out.println("Done registering new user!");
                    choice = 4;
                    break;
                default:
                    System.out.println("Default case selected");
            }
            input.nextLine();
        } while (choice != 0);
    }
}





/*
    public void runMenu(){
        printHeader();
        while(!exit){
            printMenu();
            int choice = getChoice();
        }
    }

    private int getChoice(){
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 2){
            try {
                System.out.print("\nPlease Enter Choice: ");
                choice = Integer.parseInt(kb.nextLine());
            } catch(NumberFormatException e){
                System.out.println("Invalid Choice, please try again");
            }
        }
        return choice;
    }

    private void printHeader(){
        System.out.println("*---------------------------------------------------*");
        System.out.println("|                                                   |");
        System.out.println("|            Welcome the our bank!                  |");
        System.out.println("|                                                   |");
        System.out.println("|                                                   |");
        System.out.println("*---------------------------------------------------*");
    }

    private void printMenu(){
        System.out.println("Please Make a Selection: ");
        System.out.println("(1) Login");
        System.out.println("(2) Register new user");
        System.out.println("(0) Exit");
    }

    private void performAction(int choice){
        switch(choice){
            case 0:
                exit = true;
                System.out.println("Thank you for visiting our Bank, Please com again (^_^)");
                break;
            case 1:
                currentUserID = loginUser(numOfUsers, userList, currentUserID);
                break;
            case 2:
                System.out.println("Registering new user..");
                newUser(numOfUsers, userList);
                break;
            default:
                System.out.println("Default case selected");
        }
    }
}

         if(user.equals("Leia") && (pass.equals("jedi"))){
            System.out.println("Welcome " + user);
        }else {
            System.out.println("Username and password do not match any current users, would you like to register? Y/N");
            String register;
            register = input.nextLine();

            if(register.equals("Y") || register.equals("y")){
                newUser(numOfUsers);
            }else {
                System.out.println("You've opted not to register, goodbye");
                exit();
            }
        }
  */