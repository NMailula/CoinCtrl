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

   // private final LocalDate localDate = LocalDate.now();

    // Main method to run the entire application
    public static void main(String[] args) throws SQLException {

        CoinCtrl cc = new CoinCtrl();
        Scanner scan = new Scanner(System.in);

        // Welcome message to the Application
        System.out.println(" \n*** Welcome to CoinCtrl ***" +
                "\n| A Personal Financial Journaling Application |");

        // Menu-Screen
        System.out.println("\n 1) Review Expenses" + "\n 2) Record Daily Expenses" +
                "\n 3) Monthly Financial Budget " + "\n 4) Record Monthly Income" +"\n------------------");

        System.out.print("~>");

        // switch to application's submodules
switch (scan.nextInt()) {

    // Module to review Monthly expenses
    case 1: cc.ReviewExpenses();
    break;


    // Module to record daily expenses
    case 2: cc.DailyExpenses();
    break;

    // Module to review Monthly Budget (to be developed)
    case 3: cc.MonthlyBudget();
    break;

    // Module to record monthly income
    case 4: cc.MonthlyIncome();
    break;
}

    }

    // Method to review Expenses
    public void ReviewExpenses(){

        DBAdmin adm = new DBAdmin();

        adm.DEDataImport();



    }

    // Method to record daily expenses
    public void DailyExpenses(){

        DBAdmin admin = new DBAdmin();

        //
        Scanner  scan = new Scanner(System.in);

        System.out.println("\n** Daily Expense Tracker **");
        //
        System.out.print("\n Title of Expense ~> ");
        String title = scan.nextLine();
        //
        System.out.print("\n Amount ~>R");
        double  amount = scan.nextDouble();
        //
        String type = "";
        
        System.out.print("\n Type of Expense (Fixed/Variable) ~>");
        if (scan.nextLine().equals("Fixed")) {
            System.out.println("Enter valid option");
        } else {
             type = scan.nextLine();

        }
        //String ExpenseType = scan.toString();
        //
        Date transactionDate = Date.valueOf(LocalDate.now());


        admin.DailyExpenseRecorder(title, amount, type, transactionDate);

    }

    // Method to review Monthly budget (To be developed)
    public void MonthlyBudget(){}

    // Method to record user's monthly income data
    public void MonthlyIncome() throws SQLException {

        DBAdmin admin = new DBAdmin();

        // Scanner object to allow user interaction with the system
        Scanner input = new Scanner(System.in);

        System.out.println("\n **Monthly Income Module **");

        //
        System.out.print("\n Source of Income~> ");
        String IncomeSource = input.nextLine();

        //
        System.out.print("\n Expected Amount: R");
        double ExpectedAmount = input.nextDouble();

        //
        System.out.print("\n Actual Amount: R");
        double ActualAmount = input.nextDouble();


        // Syntax for date (importing date from local system)
        Date IncomeDate = Date.valueOf(LocalDate.now());

        // Parsing user's data to the MonthlyIncomeRecorder method (DBAdmin class)
        admin.MonthlyIncomeRecorder(IncomeSource, ExpectedAmount, ActualAmount, IncomeDate);
    }


}
