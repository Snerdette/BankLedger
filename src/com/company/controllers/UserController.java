package com.company.controllers;

import com.company.entities.Checking;
import com.company.entities.Transaction;
import com.company.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static String PASSWORD_POLICY_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*])(?=\\S+$).{8,}$";
    private static String USERNAME_POLICY_PATTERN = "^(?=.*[a-z]).{8,}$";

    public static int loginUser(int numOfUsers, ArrayList<User> userList, int currentUserID){

        String inUsername, inPassword;

        boolean isValid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your username: ");
        inUsername = input.nextLine();

        System.out.println("Enter your password: ");
        inPassword = input.nextLine();

        Iterator itr = userList.iterator();

        while(itr.hasNext()){
            User user = (User)itr.next();
            System.out.println("Iterator: Username: " + inUsername);

            if(user.getUsername().equals(inUsername) && user.getPassword().equals(inPassword)){
                System.out.println("Username and password have been validated, Welcome " + user.getUsername());
                isValid = true;
                currentUserID = user.getId();
            }
        }

        return currentUserID;
    }


    public static User newUser(int numOfUsers, ArrayList<User> userList){

        System.out.println("Getting ready to welcome a new user....");

        String username, password;
        boolean userValid = false;
        boolean passwordValid = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Username must have at least one lowercase, one uppercase letters, one special character, and be at least 8 characters long");
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

        User thisUser = new User(username, password, numOfUsers);
        int tempId = thisUser.getId();
        Checking newChecking = new Checking(tempId);
        userList.add(thisUser);

        System.out.println("Welcome " + username + " to our bank!");

        return thisUser;
    }

    public static boolean validateNewPassword(String password){
        boolean valid = false;

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(PASSWORD_POLICY_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    private static boolean validateNewUsername(String username) {
        boolean valid = false;

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(USERNAME_POLICY_PATTERN);
        matcher = pattern.matcher(username);

        return matcher.matches();
    }

    public static void printAllUsers(ArrayList<User> userList){
        Iterator itr = userList.iterator();

        while(itr.hasNext()){
            User user = (User)itr.next();
            System.out.println("ID: " + user.id + " Username: " + user.username + " Password: " + user.password);
        }
    }
}
