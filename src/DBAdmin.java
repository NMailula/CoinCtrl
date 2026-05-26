/*


* */

// importing necessary libraries

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;


// Data admin class -> Handles interaction between CoinCtrl's logic and the database
public class DBAdmin {



    // Methods for Expenses-related DB operations

    //**---------------------------------------------------------------------------------------------------------**

  // Method to record the user's daily expenditures
    public void DailyExpenseRecorder(String title, double amount, String type, Date transactionDate) {

        //
        DBConnection dbConnection = new DBConnection();

        //
        String UploadDailyExpense = "INSERT INTO dailyexpensetracker (Title, Amount, Transaction_Date, Type) VALUES (?, ?, ? ,?)";

        try(Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UploadDailyExpense)){

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

        // SQL query to select all expense data (no specification of data)
        String ImportExpenses = "SELECT * FROM dailyexpensetracker";

        // Syntax to import expense data
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt1 = connection.prepareStatement(ImportExpenses);
            ResultSet rs = pstmt1.executeQuery()){


            // While-loop to display all data
            while(rs.next()){

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

    // Method to import expense data by specified time()
    public void ExpensesByTime(String monthInput){

        // SQL script to import expense data by time (Month)
        String MonthSQLQuery = "SELECT * FROM dailyexpensetracker WHERE LOWER(MONTHNAME(Transaction_Date)) LIKE ? OR LOWER(DATE_FORMAT(Transaction_Date, '%b')) LIKE ?";
        String search = "%" +  monthInput + "%";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(MonthSQLQuery)
        ){


           stmt.setString(1, search);
           stmt.setString(2, search);

           ResultSet rs = stmt.executeQuery();

           // Displaying results
            System.out.println("----------------------------------");
            while(rs.next()){
                System.out.println("\n<------->" +
                       "\nTitle: " + rs.getString("Title") + "\n" +
                       "Amount: R" + rs.getDouble("Amount") + "\n" +
                        "Date: "+ rs.getDate("Transaction_Date") + "\n" +
                        "Type: " + rs.getString("Type") + "\n<------->"


                );
            }
            System.out.println("----------------------------------");


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    // Method to import expenses by type (Variable/Fixed)
    public void ExpensesByType(String typeInput){


        // SQL script to import data by type
        String typeSQLQuery = "SELECT * FROM dailyexpenseTracker WHERE Type LIKE ?";

        try (Connection connection = DBConnection.getConnection();
        PreparedStatement qstmt = connection.prepareStatement(typeSQLQuery)) {

            qstmt.setString(1, typeInput);

            ResultSet trs = qstmt.executeQuery();

            // Displaying results
            System.out.println("----------------------------------");
            while(trs.next()){
                System.out.println("\n<------->" +
                        "\nTitle: " + trs.getString("Title") + "\n" +
                        "Amount: R" + trs.getDouble("Amount") + "\n" +
                        "Date: "+ trs.getDate("Transaction_Date") + "\n" +
                        "Type: " + trs.getString("Type") + "\n<------->"


                );
            }
            System.out.println("----------------------------------");




        }catch (SQLException e){
            e.printStackTrace();
        }



    }


    // Method to import expense data by specified time and type
    public void ExpenseByMonthType(String SpecifiedMonth, String TypeInput){

        // SQL Query to import expense data by both specified time (month) and type
        String MonthTypeSQLQuery = "SELECT * FROM dailyexpenseTracker WHERE MONTHNAME(Transaction_Date) LIKE ? AND Type LIKE ?";

        try(Connection connection = DBConnection.getConnection();
       PreparedStatement mstmt = connection.prepareStatement(MonthTypeSQLQuery)) {


            mstmt.setString(1, SpecifiedMonth);
            mstmt.setString(2, TypeInput);

            ResultSet mtrs = mstmt.executeQuery();


            // Displaying results
            System.out.println("----------------------------------");
            while(mtrs.next()){
                System.out.println("\n<------->" +
                        "\nTitle: " + mtrs.getString("Title") + "\n" +
                        "Amount: R" + mtrs.getDouble("Amount") + "\n" +
                        "Date: "+ mtrs.getDate("Transaction_Date") + "\n" +
                        "Type: " + mtrs.getString("Type") + "\n<------->"


                );
            }
            System.out.println("----------------------------------");



        } catch (SQLException e){
            e.printStackTrace();
        }



    }

    // Method to save expense data into a CSV file (backing up data)
  public void ExpenseDocWriter(){

        // String query
      String query = "SELECT * FROM dailyexpensetracker";

      // filepath
      String filePath = "expenses_export.csv";

      try(Connection conn = DBConnection.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      FileWriter writer = new FileWriter(filePath)){


          // Get table metadata
          ResultSetMetaData rsmd = rs.getMetaData();

          int columnCount = rsmd.getColumnCount();

          // Writing column headers
          for(int i = 1; i <= columnCount; i++){

              writer.append(rsmd.getColumnName(i));

              if(i < columnCount){

                  writer.append(",");
              }
          }
          writer.append("\n");


          // writing data directly to CSV
          while(rs.next()){

              for(int i = 1; i <= columnCount; i++){
                  Object value = rs.getObject(i);

                  writer.append(String.valueOf(value));

                  if(i < columnCount){
                      writer.append(",");
                  }
              }
              writer.append("\n");
          }

          writer.flush();



      }catch (SQLException e){
          e.printStackTrace();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }


  }



    //**-------------------------------------------------------------------------------------------------**


    // ** Methods for Income-related DB Operations **

    // ------------------------------------------------------------------------------------------------------

    // Method to record the user's monthly income data
    public void MonthlyIncomeRecorder(String incomeSource, double expectedAmount, double actualAmount, Date incomeDate) throws SQLException {

        // SQL Query to insert into specified database table
        String UploadIncomeData = "INSERT INTO monthlyincome (Income_Source, Expected_Amount, Actual_Amount, MI_Date) VALUES (?, ?, ?, ?)";

        // Try-Catch block of code
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UploadIncomeData)){

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

    // Method to import All income data
    public void ImportIncomeData(){

        // SQL query to select all income data (no specification)
        String ImportIncome = "SELECT * FROM monthlyincome";

        // Syntax to import import data
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement incomestmt = connection.prepareStatement(ImportIncome);
        ResultSet incomeRs = incomestmt.executeQuery()){

            // While-loop to display all data
            while(incomeRs.next()){
                //
                System.out.println(
                        "\n Title of Income: " + incomeRs.getString("Income_Source") +
                                "\n Predicted Income Amount: R" + incomeRs.getDouble("Expected_Amount") +
                                "\n Actual Income Amount: R" + incomeRs.getDouble("Actual_Amount") +
                                "\n Difference: R" + incomeRs.getDouble("difference") +
                                "\n Date of income transaction: " + incomeRs.getDate("MI_Date")
                );


            }




        }catch (SQLException e){
            System.out.println("Database Related error has occurred" + e.getMessage());
        }


    }

    // Method to import income data by time
    public void IncomeByTime(String IncomeMonthInput){

        // SQL script to import income data by time (Month)
        String SQLIncomeMonthQuery = "SELECT * FROM monthlyincome WHERE LOWER(MONTHNAME(MI_Date)) LIKE ? OR LOWER(DATE_FORMAT(MI_Date, '%b')) LIKE ?";
        String search = "%" +  IncomeMonthInput + "%";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(SQLIncomeMonthQuery)){

            pstmt.setString(1, search);
            pstmt.setString(2, IncomeMonthInput);

            ResultSet trs = pstmt.executeQuery();

            // Displaying results
            System.out.println("----------------------------------");
            while(trs.next()){
                System.out.println("\n<------->" +
                        "\nTitle: " + trs.getString("Income_Source") + "\n" +
                        "Expected Amount: R" + trs.getDouble("Expected_Amount") + "\n" +
                        "Actual Amount: R: "+ trs.getDouble("Actual_Amount") + "\n" +
                        "Difference: R" + trs.getDouble("difference") +
                        "Income transaction date: " +  trs.getDate("MI_Date") + "\n" +
                        "\n<------->"


                );
            }
            System.out.println("----------------------------------");



        } catch(SQLException e) {
            System.out.println("Database Related error has occurred" + e.getMessage());
        }


    }

    // Method to dave income data into a csv file (backing up data)
    public void IncomeDocWriter(){

        // String query
        String query = "SELECT * FROM monthlyincome";

        // filepath
        String filePath = "income_export.csv";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            FileWriter writer = new FileWriter(filePath)){


            // Get table metadata
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();

            // Writing column headers
            for(int i = 1; i <= columnCount; i++){

                writer.append(rsmd.getColumnName(i));

                if(i < columnCount){

                    writer.append(",");
                }
            }
            writer.append("\n");


            // writing data directly to CSV
            while(rs.next()){

                for(int i = 1; i <= columnCount; i++){
                    Object value = rs.getObject(i);

                    writer.append(String.valueOf(value));

                    if(i < columnCount){
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }

            writer.flush();



        }catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // ------------------------------------------------------------------------

}

/*
** Note **

 Future versions of the application, it may be necessary to create a class to handle CSV file writing

 */