package com.company.controllers;

import com.company.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static String PASSWORD_POLICY_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static String USERNAME_POLICY_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    public static boolean validateUser(String inUsername, String inPassword, ArrayList<User> userList){

        boolean isValid = false;

        Iterator itr = userList.iterator();

        while(itr.hasNext()){
            User user = (User)itr.next();
            System.out.println("Username: " + inUsername + " Password: " + inPassword);
        }

        return isValid;
    }

    public static void newUser(int numOfUsers, ArrayList<User> userList){
        String username;
        String password;
        boolean userValid = false;
        boolean passwordValid = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Username must have at least one lowercase, one uppercase letters, one special character, and be at least 8 characters long");
        System.out.println("Please enter a new username: ");
        username = input.nextLine();

        do {
            System.out.println("Invalid username, Username must have at least one lowercase, one uppercase letters, one special character, and be at least 8 characters long ");
            System.out.println("Please enter a new username: ");
            username = input.nextLine();
        }
        while(!validateUsername(username));


        if(validateUsername(username)){

            System.out.println("Please enter a new password: ");
            password = input.nextLine();

            if(validatePassword(password)){
                User newUser = new User(username, password, numOfUsers);
            }

        } else {
            System.out.println("Invalid username, please");
        }

    }

    public static boolean validatePassword(String password){
        boolean valid = false;

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(PASSWORD_POLICY_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    private static boolean validateUsername(String username) {
        boolean valid = false;

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(USERNAME_POLICY_PATTERN);
        matcher = pattern.matcher(username);

        return matcher.matches();
    }
}
