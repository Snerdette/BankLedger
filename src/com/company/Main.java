// Kathryn LaFrance
//Bank Ledger
//

package com.company;

import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import src.com.company.entities.User;

import static javafx.application.Platform.exit;



public class Main {

    private static String PASSWORD_POLICY_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static String USERNAME_POLICY_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    List<User> userList;

    static int numOfUsers = 1; //Used to set user ID's

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String user, pass;

        System.out.println("Enter your username: ");
        user = input.nextLine();

        System.out.println("Enter your password: ");
        pass = input.nextLine();

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

    }

    private static void displayMenu() {
        double thc;
        double cm;

        Scanner reader;

        System.out.println("Please enter the Length in CM");
        reader=new Scanner(System.in);

        cm=reader.nextDouble();
        thc=cm/100;

        System.out.print("The length is: ");
        System.out.println(thc);

    }

    public static void newUser(int numOfUsers){
        String username;
        String password;

        Scanner input = new Scanner(System.in);
        System.out.println("Username mut have at least one lowercase, one uppercase letters, one special character, and be at least 8 characters long");
        System.out.println("Please enter a new username: ");
        username = input.nextLine();

        if(validateUsername(username)){

            System.out.println("Please enter a new password: ");
            password = input.nextLine();

            if(validatePassword(password)){
                User newUser = new User(username, password);
            }

        } else {
            System.out.println("Invalid username, please");
        }

    }


    public static boolean validateUsername(String username){
        boolean valid = false;

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(USERNAME_POLICY_PATTERN);
        matcher = pattern.matcher(username);

        return matcher.matches();
    }


    public static boolean validatePassword(String password){
        boolean valid = false;

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(PASSWORD_POLICY_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

}
/*

^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$
Explanation:

^                 # start-of-string
(?=.*[0-9])       # a digit must occur at least once
(?=.*[a-z])       # a lower case letter must occur at least once
(?=.*[A-Z])       # an upper case letter must occur at least once
(?=.*[@#$%^&+=])  # a special character must occur at least once
(?=\S+$)          # no whitespace allowed in the entire string
.{8,}             # anything, at least eight places though
$                 # end-of-string
 */