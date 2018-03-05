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

    public static User loginUser(){
        String inUsername, inPassword;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your username: ");
        inUsername = input.nextLine();

        System.out.println("Enter your password: ");
        inPassword = input.nextLine();



        return currentUser;
    }

    public static boolean verifyUser(int numOfUsers, ArrayList<User> userList){

        boolean isValid = false;

        Iterator itr = userList.iterator();

        for(user: userList){

        }
        while(itr.hasNext()){
            User user = (User)itr.next();
            System.out.println("Username: " + inUsername);

            if()
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
            System.out.println("Invalid username, Username must have at least one lowercase, one uppercase letters, and be at least 8 characters long ");
            System.out.println("Please enter a new username: ");
            username = input.nextLine();
        }
        while(!validateNewUsername(username));

        if(validateNewUsername(username)){

            System.out.println("Please enter a new password: ");
            password = input.nextLine();
            do{
                System.out.println("Invalid password, Password must have at least one lowercase, one uppercase letters, one special character, and be at least 8 characters long ");
                System.out.println("Please enter a new password: ");
                password = input.nextLine();
            }
            while(!validateNewPassword(password));

            User newUser = new User(username, password, numOfUsers);
            userList.add(newUser);

        } else {
            System.out.println("Invalid username, please try again");
        }


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
