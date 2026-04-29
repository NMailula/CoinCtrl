/*


* */

// importing necessary libraries
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

// Data admin class -> Handles interaction between CoinCtrl's logic and the database
public class DBAdmin {

  // Method to record the user's daily expenditures
    public void DailyExpenseRecorder(String title, double amount, String type, Date transactionDate) {

        //
        DBConnection dbConnection = new DBConnection();

        //
        String UploadDailyExpense = "INSERT INTO dailyexpensetracker (Title, Amount, Transaction_Date, Type) VALUES (?, ?, ? ,?)";

        try(Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UploadDailyExpense);){

            preparedStatement.setString(1, title);
            preparedStatement.setDouble(2, amount);
            preparedStatement.setDate(3, transactionDate);
            preparedStatement.setString(4, type);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\n ** Expenses recorded successfully **");
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    // Method to import all expenses data (future version will allow user to specify time-frame such as month)
    public void DEDataImport() {

        // SQL query to select all expenses
        String ImportExpenses = "SELECT * FROM dailyexpensetracker";

        //
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt1 = connection.prepareStatement(ImportExpenses);
            ResultSet rs = pstmt1.executeQuery();){


            // While loop to display all data
            while(rs.next()){
                //
                System.out.println(
                     "\n Title of Expense: " +  rs.getString("Title") +
                             "\n Amount: R" + rs.getDouble("Amount") +
                             "\n Date of Transaction: " + rs.getDate("Transaction_Date") +
                             "\n Expense Type: " + rs.getString("Type")
                        + "\n----------"
                );
            }

        }
        // Basic exception handling
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    // Method to display all financial activities (future versions will allow users to see data for a specific month, or multiple months)
    public void MBDataImport() {}

    // Method to record the user's monthly income data
    public void MonthlyIncomeRecorder(String incomeSource, double expectedAmount, double actualAmount, Date incomeDate) throws SQLException {

        //
        DBConnection dbConnection = new DBConnection();

        // SQL Query to insert into specified database table
        String UploadIncomeData = "INSERT INTO monthlyincome (Income_Source, Expected_Amount, Actual_Amount, MI_Date) VALUES (?, ?, ?, ?)";

        // Try-Catch block of code
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UploadIncomeData);){

            //Uploading daily expenditure data
            pstmt.setString(1, incomeSource);
            pstmt.setDouble(2, expectedAmount);
            pstmt.setDouble(3, actualAmount);
            pstmt.setDate(4, incomeDate);


            int rowsAffected = pstmt.executeUpdate();

            // If data has been successfully upload to DB, a message should be printed out
            if(rowsAffected > 0){
                System.out.println("\nIncome Data successfully recorded!");
            }

        }
        // Basic exception handling for any SQL-related errors
        catch(SQLException e){
            e.printStackTrace();
        }

    }



}
