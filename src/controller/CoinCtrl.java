package controller;

// This class will act as the UI Layer of the entire Coinctrl application (represents the front-end of the application). All user interactions with the system will be handled by this class only

//
import java.time.LocalDate;
import java.util.Scanner;

import model.Expense;

// Controller (main) class
public class CoinCtrl {

    static Scanner CoinCtrl = new Scanner(System.in);


// ------------------------------ All income-related UI ------------------------------

    // Add Income UI
public static void AddIncome(){}

    // View All income data
    public static void ReviewIncomeData(){}

    // View time-specified income data (month)
    public static void ReviewIncomeByMonth(){}


    // -----------------------------



    // ------------------------------ All income-related UI ------------------------------

    // Add Expense
    public static void addExpense(){

    String ExpenseTitle;
    double ExpenseAmount;
    String ExpenseType;
    LocalDate ExpenseDate =  LocalDate.now();

    System.out.println("\n===================" +
            "\n Add Expense Module"
    );

    System.out.print("Enter Expense Title -> ");
    ExpenseTitle = CoinCtrl.next();

    System.out.print("Enter Expense Amount -> R");
    ExpenseAmount = CoinCtrl.nextDouble();

    System.out.print("Enter Expense Type -> ");
    ExpenseType = CoinCtrl.next();


    // Pass data to ExpenseRepository.java
        System.out.println("\nExpense: " +  ExpenseTitle + "\n Expense Amount " + ExpenseAmount + "\n Expense Type: " + ExpenseType
                + "\n Transaction Date: " + ExpenseDate);

    }

    // View All Expense data
    public static void ReviewAllExpenseData(){}

    // View Expense data by type
    public static void ReviewExpenseByType(){}

    // View Expense data by month
    public static void ReviewExpenseByMonth(){}

    // View Expense data by both month and type
    public static void ReviewExpenseByTNT(){}


    // -----------------------------

    // Main method to start the entire application
public static void main(String[] args){

// Printing the main menu screen
    System.out.println("\n *** CoinCtrl ***" +
            "\n--------------"

                    // Income Menu options
                    + "\n 1) Add Income" + "\n 2) Review All Income"
            + "\n 3) Review Income By Time" +

            // Expense Menu options
            "\n 4) Add Expense" + "\n 5) Review All Expenses" +
            "\n 6) Review Expense By Type" + "\n 7) Review Expense By Time"
            +"\n 8) Review Expense By Time and Type" +

            "\n--------------"
    );

    //
    System.out.print("\n ==> ");
    String mainMenuInput = CoinCtrl.nextLine();


 switch(mainMenuInput){

     case "1":
         System.out.println("Add Income");
         break;

         case "2":
             System.out.println("Review All Income");
             break;

             case "3":
                 System.out.println("Review Income By Time");
                 break;

                 case "4":
                     System.out.println("Add Expense");
                     addExpense();
                     break;

                     case "5":
                         System.out.println("Review All Expenses");
                         break;

                         case "6":
                             System.out.println("Review Expense By Type");
                             break;

                             case "7":
                                 System.out.println("Review Expense By Month");
                                 break;

                                 case "8":
                                     System.out.println("Review Expenses By month and type");
                                     break;


                                     default:
                                         System.out.println("Invalid Input");
                                         break;





 }

}

}
