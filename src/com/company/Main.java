// Kathryn LaFrance
//Bank Ledger
//

package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import com.company.entities.User;
import com.company.services.UserService;

import static com.company.controllers.UserController.newUser;
import static com.company.controllers.UserController.validateUser;
import static com.company.controllers.UserController.verifyUser;
import static javafx.application.Platform.exit;



public class Main {



    static ArrayList<User> userList = new ArrayList<User>();

    static int numOfUsers = 0; //Used to set user ID's

    public static void main(String[] args) {

        boolean exit = false;
        User currentCustomer;
        Main main = new Main();
        main.runMenu(exit);

    }

    public void runMenu(boolean exit){
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
        switch(){
            case 1:
                //verifyUser(numOfUsers, userList);
                break;
            case 2:
                newUser(numOfUsers, userList);
                break;
            case 3:

        }
    }
}
 /*
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