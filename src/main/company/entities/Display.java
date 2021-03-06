package main.company.entities;

import main.company.controllers.CheckingController;
import main.company.controllers.TransactionController;
import main.company.controllers.UserController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    static ArrayList<User> userList = new ArrayList<User>();
    static User currentUser;

    public void runLoginMenu(){

        int choice = -1;
        Scanner input = new Scanner(System.in);
        currentUser = null;
        CheckingController cController = new CheckingController();
        UserController uController = new UserController();

        System.out.println("*---------------------------------------------------*");
        System.out.println("|            Welcome the THE bank!                  |");
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
                    System.out.println("Thank you for visiting THE Bank, Please com again (^_^)");
                    input.nextLine();
                    break;
                case 1:
                    currentUser = uController.loginUser(userList, currentUser);
                    if(currentUser == null){
                        runLoginMenu();
                    }
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 2:
                    currentUser = uController.newUser(userList);
                    input.nextLine();
                    choice = 4;
                    runUserMenu(currentUser);
                    break;
                default:
                    System.out.println("Invalid input, please select options 1, 2, or 0 to exit");
                    input.nextLine();
                    runLoginMenu();
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

        TransactionController tController = new TransactionController();
        CheckingController cController = new CheckingController();

        DecimalFormat dec = new DecimalFormat("#0.00");

        System.out.println("*---------------------------------------------------*");
        System.out.println("              Welcome "+currentUser.getUsername()+" ");
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
                    System.out.println("Thank you for visiting THE Bank, Please come again (^_^)");
                    break;
                case 1:
                    System.out.println("How Much would you like to deposit?");
                    amount = input.nextDouble();
                    cController.updateBalance(amount, "Deposit", currentUser);
                    input.nextLine();
                    amount = 0.00;
                    runUserMenu(currentUser);
                    break;
                case 2:
                    System.out.println("How Much would you like to withdraw?");
                    amount = input.nextDouble();
                    cController.updateBalance(amount, "Withdrawal", currentUser);
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 3:
                    tController.printAllTransactions(currentUser);
                    input.nextLine();
                    runUserMenu(currentUser);
                    break;
                case 4:
                    currentUser = null;
                    runLoginMenu();
                    break;
                default:
                    System.out.println("Invalid input, please select options 1, 2, 3, 4, or 0 to exit");
                    input.nextLine();
                    runUserMenu(currentUser);
            }
            input.nextLine();
        } while (choice != 0);
    }
}
