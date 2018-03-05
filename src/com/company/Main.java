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
import static javafx.application.Platform.exit;



public class Main {



    static ArrayList<User> userList = new ArrayList<User>();

    static int numOfUsers = 1; //Used to set user ID's

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String inUsername, inPassword, currentCustomer;

        System.out.println("Welcome to the Bank!");
        System.out.println("Do you have an account? Y/N");
        currentCustomer = input.nextLine();

        if(currentCustomer.equals("N") || currentCustomer.equals("n")){
            newUser(numOfUsers, userList);
        }
        else if (currentCustomer.equals("Y") || currentCustomer.equals("y")){

            System.out.println("Enter your username: ");
            inUsername = input.nextLine();

            System.out.println("Enter your password: ");
            inPassword = input.nextLine();

            validateUser(inUsername, inPassword, userList);
        }
        else {
            System.out.println("Invalid input");
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