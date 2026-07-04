package controller;

// This class will act as the UI Layer of the entire Coinctrl application (represents the front-end of the application). All user interactions with the system will be handled by this class only

//

import service.*;
import model.*;
import repository.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


// Controller (main) class
public class CoinCtrl {

    static Scanner CoinCtrl = new Scanner(System.in);

    static ExpenseService service = new ExpenseService();
    static LocalDate ExpenseDate = LocalDate.now();



// ------------------------------ All income-related UI syntax ------------------------------

    // Add Income UI
public static void AddIncome(){}

    // View All income data
    public static void ReviewIncomeData(){}

    // View time-specified income data (month)
    public static void ReviewIncomeByMonth(){}


    // -----------------------------



    // ------------------------------ All income-related UI syntax ------------------------------

    // Add Expense
    public static void addExpenseUI() {

        //
        String ExpenseTitle;
        while (true) {

            System.out.print("Enter Expense Title: ");
            ExpenseTitle = CoinCtrl.nextLine().trim();

            if (!ExpenseTitle.matches("[a-zA-Z]+")) {
                System.out.println("Error: Invalid Expense Title");
            } else {
                break;
            }

        }

        //
        double ExpenseAmount;
        while (true) {
            try {
                System.out.print("Enter Expense Amount: R");
                ExpenseAmount = CoinCtrl.nextDouble();

                if (ExpenseAmount < 0) {
                    System.out.println("ERROR: Expense can't be negative");
                } else {
                    // syntax added to avoid the 3rd while-loop from breaking before user input
                    CoinCtrl.nextLine();

                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("*** Error: Expense must be numerical ***");
                CoinCtrl.next();
            }
        }

        //
        String ExpenseType;
        while (true) {
            System.out.print("Enter Expense Type: ");
            ExpenseType = CoinCtrl.nextLine().trim();

            if (ExpenseType.isEmpty()) {
                System.out.println("Error: Expense Type can't be empty");
                continue;
            }
            if (ExpenseType.equalsIgnoreCase("Variable") || ExpenseType.equalsIgnoreCase("Fixed")) {
                break;
            } else {
                System.out.println("Error: Invalid Expense Type input");
            }

        }

        service.InputValidation(ExpenseTitle,ExpenseAmount, ExpenseType, ExpenseDate);

    }

    // View All Expense data
    public static void ReviewAllExpenseData(){}

    // View Expense data by type
    public static void ReviewExpenseByType(){

    // Searching for specific expense type
    System.out.println("\n **** Reviewing Expenses By Type ****" );

    while(true){
        System.out.print("Enter Expense Type -> ");
        String ExpenseType = CoinCtrl.nextLine().trim();

        if (ExpenseType.equalsIgnoreCase("Variable") || ExpenseType.equalsIgnoreCase("Fixed")){
            System.out.println(ExpenseType);
            break;
        } else{
            System.out.println(ExpenseType + " is not an expense type; please try again");
        }
    }


    }

    // View Expense data by month
    public static void ReviewExpenseByMonth(){}

    // View Expense data by both month and type
    public static void ReviewExpenseByTNT(){}


    // -----------------------------

    // Main method to start the entire application
public static void main(String[] args) {

// Printing the main menu screen
    System.out.println("\n *** CoinCtrl ***" +
            "\n--------------"

            // Income Menu options
            + "\n 1) Add Income" + "\n 2) Review All Income"
            + "\n 3) Review Income By Time" +

            // Expense Menu options
            "\n 4) Add Expense" + "\n 5) Review All Expenses" +
            "\n 6) Review Expense By Type" + "\n 7) Review Expense By Time"
            + "\n 8) Review Expense By Time and Type" +

            "\n--------------"
    );

    int mainMenuInput;

    while (true) {
        try {
            System.out.print("==> ");
            mainMenuInput = CoinCtrl.nextInt();

            if (mainMenuInput <1  || mainMenuInput > 8) {
                System.out.println("Invalid Input: Choose between 1 and 8");
            } else {
                break;
            }


        } catch (InputMismatchException e) {
            System.out.println("\nError: Please enter a valid option [1-8]");
            CoinCtrl.nextLine();
        }
    }

    switch (mainMenuInput) {

        case 1:
            System.out.println("Add Income");
            AddIncome();
            break;

        case 2:
            System.out.println("Review All Income");
            break;

        case 3:
            System.out.println("Review Income By Time");
            break;

        case 4:
            System.out.println("Add Expense");
            addExpenseUI();
            break;

        case 5:
            System.out.println("Review All Expenses");
            break;

        case 6:
            System.out.println("Review Expense By Type");
            ReviewExpenseByType();
            break;

        case 7:
            System.out.println("Review Expense By Month");
            break;

        case 8:
            System.out.println("Review Expenses By month and type");
            break;


        default:
            System.out.println("Invalid Input");
            break;


    }

}

}
