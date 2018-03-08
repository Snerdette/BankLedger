package com.company.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.entities.Checking;
import com.company.entities.User;

public class UserController {

    private static String PASSWORD_POLICY_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,}$";
    private static String USERNAME_POLICY_PATTERN = "^(?=.*[a-z]).{8,}$";

    public static User loginUser(int numOfUsers, ArrayList<User> userList, User currentUser) {

        String inUsername, inPassword;
        boolean found = false;

        Scanner input = new Scanner(System.in);
        Iterator itr = userList.iterator();

        System.out.println("Enter your username: ");
        inUsername = input.nextLine();

        System.out.println("Enter your password: ");
        inPassword = input.nextLine();


        if(userList.size() <= 0){
            System.out.println("There are no registered users, please register!");
        }
        else {
            do {
                User user = (User) itr.next();

                if (user.getUsername().equals(inUsername)) {
                    found = true;
                    if(user.getPassword().equals(inPassword)){
                        System.out.println("Username and password have been validated, Welcome " + user.getUsername());
                        currentUser = user;
                    } else {
                            System.out.println("Incorrect Password, if you forgot the password please contact the network administrator");
                    }
                } else {

                }
            } while (itr.hasNext());
        }

        if(!found){
            System.out.println("Username does not match any on record, please register or contact your local branch");
            System.out.println("Remember that username's and passwords are case sensitive");
        }
        return currentUser;
    }

    public static User newUser(int numOfUsers, ArrayList<User> userList){

        String username, password;

        Scanner input = new Scanner(System.in);

        System.out.println("Getting ready to welcome a new user....");
        System.out.println("Username Requirements:");
        System.out.println("1 lowercase, 1 uppercase letters, 1 special character, and a length of 8 or more");
        System.out.println("Please enter a new username: ");

        username = input.nextLine();

        if(!validateNewUsername(username)){
            do {
                System.out.println("Invalid username, Username must be at least 8 characters long. please try again: ");
                username = input.nextLine();
            }
            while(!validateNewUsername(username));
        }

        System.out.println("Please enter a new password: ");
        password = input.nextLine();

        if(!validateNewPassword(password)){

            do{
                System.out.println("Invalid password, Password must have at least one lowercase, one uppercase letters, one special character, and be at least 8 characters long ");
                System.out.println("Please enter a new password: ");
                password = input.nextLine();
            }
            while(!validateNewPassword(password));
        }

        User thisUser = new User(username, password);

        Checking checking = thisUser.getChecking();
        ArrayList<Checking> accounts = checking.getAccounts();

        userList.add(thisUser);

        System.out.println("Welcome " + username + " to our bank!");

        return thisUser;
    }

    public static double getBalanceForUser(User currentUser){
        double balance = 0.00;
        CheckingController.getBalanceForUser(currentUser);
        return balance;
    }

    public static boolean validateNewPassword(String password){

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(PASSWORD_POLICY_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    private static boolean validateNewUsername(String username) {

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(USERNAME_POLICY_PATTERN);
        matcher = pattern.matcher(username);

        return matcher.matches();
    }

}
