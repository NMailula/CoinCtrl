/*

CoinCtrl

An application developed to record user's financial activities



*/

// Importing libraries necessary
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


// Main class of the CoinCtrl Application
public class CoinCtrl {

    
    // Main method to run/start the entire application
    public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

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
        int menuInput = scan.nextInt();

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

        Scanner scanner = new Scanner(System.in);

        // Expenses sub-menu
        System.out.println("\n ------------------" + "\n 1) Record Expenses"+ "\n 2) Review ALL Expense Data" + "\n 3) Review Expenses (By time)" +
                "\n 4) Review Expenses (By type)" + "\n 5) Review Expenses (By type and time)" +
                "\n ------------------");

        //
        System.out.print("~> ");
        int menuInput = scanner.nextInt();

        //
        switch (menuInput) {

            case 1:
                System.out.println("");
                break;

                case 2:
                    System.out.println("");
                    break;

            case 3:

        }


    }

    // Method to handle expense related operations
    public static void Income()  {

        Scanner scanner = new Scanner(System.in);

        // Expenses sub-menu
        System.out.println("\n ------------------" + "\n 1) Record Income"+ "\n 2) Review ALL Income Data"
                + "\n 3) Review Income (By time)" +
                "\n 4) Review Expenses (By type)" +
                "\n ------------------");

        System.out.print("~> ");
        int menuInput = scanner.nextInt();

        switch (menuInput) {}
    }

    // Method to handle operations for overall finances
   // public static void OverallFinances(){}
}
