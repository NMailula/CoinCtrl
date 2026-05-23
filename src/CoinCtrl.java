/*

CoinCtrl

An application developed to record user's financial activities



*/

// Importing libraries necessary
import java.util.Scanner;


// Main class of the CoinCtrl Application
public class CoinCtrl {

    private static final Scanner CoinCtrl = new Scanner(System.in);

    static FinancialOperations FO = new FinancialOperations();
    static DBAdmin DAN = new DBAdmin();

    
    // Main method to run/start the entire application
    public static void main(String[] args)  {


        // Welcome message to the Application
        System.out.println(" \n*** Welcome to CoinCtrl ***" +
                "\n| A Personal Financial Journaling Application |");

        // Main Menu-Screen
        System.out.println("\n || Main Menu ||"+ "\n 1) Expenses" + //
                "\n 2) Income" + //
                "\n 3) Overall Finances " + //
                "\n------------------");

        // User's input (main menu input)
        System.out.print("~> ");
        int menuInput = CoinCtrl.nextInt();

        //
        switch (menuInput) {

            case 1:
                Expenses();
                break;

            case 2:
                Income();
                break;

            case 3:
                //OverallFinances();
                break;

                default:
                    System.out.println("Invalid Input");
        }



    }

    // Method to handle expense related operations
    public static void Expenses()  {

       int menuInput = 0;

        // Expenses sub-menu
        System.out.println("\n ------------------" + "\n 1) Record Expenses"+ "\n 2) Review ALL Expense Data" + "\n 3) Review Expenses (By time)" +
                "\n 4) Review Expenses (By type)" + "\n 5) Review Expenses (By type and time)" +
                "\n ------------------");

        //
        System.out.print("~> ");
         menuInput = CoinCtrl.nextInt();

        //
        switch (menuInput) {

            case 1:
                System.out.println("\n** Recording Expense **");
                FO.AddExpenses();
                break;

                case 2:
                    System.out.println("\n ** REVIEWING ALL EXPENSES");
                    DAN.DEDataImport();
                    break;

            case 3:
                System.out.println("** REVIEWING EXPENSES BY TIME **");
                FO.ReviewExpensesByTime();
                break;

                case 4:
                    System.out.println("** REVIEWING EXPENSES BY TYPE **");
                    FO.ReviewExpensesByType();
                    break;

            case 5:
                System.out.println("** REVIEWING EXPENSES BY TIME AND TYPE **");
                FO.ReviewExpensesByTNT();
                break;

                default:
                    System.out.println("Invalid Input");

        }


    }

    // Method to handle expense related operations
    public static void Income()  {

        // Expenses sub-menu
        System.out.println("\n ------------------" + "\n 1) Record Income"+ "\n 2) Review ALL Income Data"
                + "\n 3) Review Income (By time)" +
                "\n ------------------");

        System.out.print("~> ");
        int menuInput = CoinCtrl.nextInt();

        switch (menuInput) {

            case 1:
                System.out.println("\n** RECORDING INCOME DATA **");
                FO.AddIncome();
                break;

            case 2:
                System.out.println("\n** REVIEWING ALL INCOME DATA **");
                FO.ReviewAllIncome();
                break;

            case 3:
                System.out.println("\n** REVIEWING INCOME (BY TIME) **");
                FO.ReviewIncomeByTime();
                break;

            default:
                System.out.println("Invalid Input");
        }
    }

    // Method to handle operations for overall finances
   // public static void OverallFinances(){}
}
