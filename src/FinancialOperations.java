
//
import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

// Class to handle user-specified Financial Operations
public class FinancialOperations {

    private static final Scanner input = new Scanner(System.in);

   static DBAdmin DAN = new DBAdmin();
   //static CoinCtrl CC = new CoinCtrl();


    // ----------------------------------------------------------------------------

    // Method to handle operations to review expenses by time
    public void ReviewExpensesByTime(){

        //
        String monthInput = "";

        while (true) {

            System.out.println("\n Enter month name to search for expense data (e.g. December or Dec)");
            System.out.print("--> ");
            monthInput = input.nextLine().trim();

            if (monthInput.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
                break;
            } else {
                System.out.println("Invalid Title input!");

            }
        }


        DAN.ExpensesByTime(monthInput);


    }

    // Method to handle operations to review expenses by type
    public void ReviewExpensesByType(){}

    // Method to handle operations to review expenses by both time and type
    public void ReviewExpensesByTNT(){}

    // Method to handle operations to add expense data
    public void AddExpenses(){

        // Declaring variables (before user-interactive syntax)

        //
        LocalDate transactionDate = LocalDate.now();

        //
        String title;

        //
        double amount = 0;

        //
        String type;

        //
        double RestrictedAmount = 0;


        //
        System.out.println("\n| Adding Expenses |");

        // Title of Expense
        while (true) {

            System.out.println("\n Enter Title of Expense");

            // Runtime error: doesn't allow input with multiple characters (e.g. 'Dunlop Newcastle')
            System.out.print("--> ");
            title = input.nextLine().trim();

            if (title.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
             break;
            } else {
                System.out.println("Invalid Title input!");

            }
        }



        // Expense Amount
        boolean validInput = false;


        while (!validInput) {

            try{

                System.out.println("\n Enter Amount of Expense (R)");
                System.out.print("--> ");
                amount = input.nextDouble();

                //
                if (amount < RestrictedAmount) {
                    System.out.println("Invalid input! Expenses cannot be negative");

                } else {
                    validInput = true;
                }



            } catch(InputMismatchException e){
                System.out.println("Invalid input! Enter proper expense amount");
                input.nextLine();
            }
        }


        // Type of Expense

        // A run-time error occurs here: syntax executes before user input is made
        while(true) {

            input.nextLine();

            System.out.println("\n Enter type of expense (Variable or Fixed)");
            System.out.print("--> ");

            type = input.nextLine().trim();

            if(type.equalsIgnoreCase("Variable") || type.equalsIgnoreCase("Fixed")){
                break;
            } else {
                System.out.println("Error: Please enter correct expense Type (FIXED OR VARIABLE)");
            }

        }

        // Uploading data into database ()
        DAN.DailyExpenseRecorder(title, amount, type, Date.valueOf(transactionDate));


    }


    // --------------------------------------------------------------------------

    // Method to handle operations to review all income data
    public void ReviewAllIncome(){}

   // Method to handle operations to review income data by time
    public void ReviewIncomeByTime(){}

    // Method to handle operations to add income data
    public void AddIncome(){}

    // -------------------------------------------------------------------------

}
