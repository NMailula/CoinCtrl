
//
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

// Class to handle user-specified Financial Operations
public class FinancialOperations {

    private static final Scanner input = new Scanner(System.in);

   static DBAdmin DAN = new DBAdmin();
   //static CoinCtrl CC = new CoinCtrl();


    // ----------------------------------------------------------------------------

    // Method to handle operations to review expenses by time (Month)
    public void ReviewExpensesByTime(){

        // Initialization of variables:
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
    public void ReviewExpensesByType(){

        //
        String typeInput = "";

        while (true) {

            System.out.println("\n Enter type of expense to search (Variable or Fixed)");
            System.out.print("--> ");

            typeInput = input.nextLine().trim();

            if (typeInput.equals("Variable") || typeInput.equals("Fixed")) {
                break;
            } else{
                System.out.println("\n** Error: Please enter correct expense type (FIXED OR VARIABLE) ***");
            }

        }

        DAN.ExpensesByType(typeInput);
    }

    // Method to handle operations to review expenses by both time and type
    public void ReviewExpensesByTNT(){

        String SpecifiedMonth = "";
        String TypeInput = "";

        // Handling month input
        while (true) {

            System.out.println("\n Enter month name to search for expense data (e.g. December or Dec)");
            System.out.print("--> ");
            SpecifiedMonth = input.nextLine().trim();

            if (SpecifiedMonth.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
                break;
            } else {
                System.out.println("Invalid Title input!");

            }
        }

        // Handling expense type input
        while (true) {

            System.out.println("\n Enter type of expense to search (Variable or Fixed)");
            System.out.print("--> ");

            TypeInput = input.nextLine().trim();

            if (TypeInput.equals("Variable") || TypeInput.equals("Fixed")) {
                break;
            } else{
                System.out.println("\n** Error: Please enter correct expense type (FIXED OR VARIABLE) ***");
            }

        }


        //
        DAN.ExpenseByMonthType(SpecifiedMonth, TypeInput);

        //
      //  DAN.ExpenseByMonthType(SpecifiedMonth, TypeInput);
    }

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
                System.out.print("--> R");
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

   // Method to handle operations to review income data by time
    public void ReviewIncomeByTime(){

        // Initialization of variables:
        String IncomeMonthInput = "";

        while (true) {

            System.out.println("\n Enter month name to search for expense data (e.g. December or Dec)");
            System.out.print("--> ");
            IncomeMonthInput = input.nextLine().trim();

            if (IncomeMonthInput.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
                break;
            } else {
                System.out.println("Invalid Title input!");

            }
        }

        DAN.IncomeByTime(IncomeMonthInput);

    }

    // Method to handle operations to add income data
    public void AddIncome() throws SQLException {

        // Declaring variables (before user-interactive syntax)
        LocalDate incomeDate = LocalDate.now();
        String incomeSource = "";
        double expectedAmount = 0;
        double actualAmount = 0;

        System.out.println("\n | Adding Income |");

        // Source of expense
        while (true) {

            System.out.println("\n Title of income");

            //
            System.out.print("--> ");
            incomeSource = input.nextLine().trim();

            if (incomeSource.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
             break;
            } else {
                System.out.println("Invalid Title input!");
            }


        }

        // Expected amount
        boolean validInput = false;
        double RestrictedAmount = 0;

      while (!validInput) {

          try{

              System.out.println("\n Enter Expected Amount of Income (R)");
              System.out.print("--> ");
              expectedAmount = input.nextDouble();


              //
              if (expectedAmount < RestrictedAmount) {
                  System.out.println("Invalid input! Expenses cannot be negative");
              } else{
                  validInput = true;
              }


          }catch (InputMismatchException e){
              System.out.println("Invalid input! Enter proper input amount");
          }

      }

        // Actual Amount
        boolean AAInput = false;

        while (!AAInput) {

            try{

                System.out.println("\n Enter Actual Amount of Income (R)");
                System.out.print("--> ");
                actualAmount = input.nextDouble();


                //
                if (actualAmount < RestrictedAmount) {
                    System.out.println("Invalid input! Expenses cannot be negative");
                } else{
                    AAInput = true;
                }


            }catch (InputMismatchException e){
                System.out.println("Invalid input! Enter proper input amount");
            }

        }







       DAN.MonthlyIncomeRecorder(incomeSource, expectedAmount, actualAmount, Date.valueOf(incomeDate));
    }

    // -------------------------------------------------------------------------

}
//