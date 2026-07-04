package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.*;


public class ExpenseRepository {

private static DBConnection dbconnection = new DBConnection();


    public  boolean saveExpense(Expense expense) {

        //
        String ExpenseDataQuery = "INSERT INTO expenses (Title, Amount, Transaction_Date, Type) VALUES (?,?,?,?,?)";

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(ExpenseDataQuery)) {

          // Setting Expense Title
            ps.setString(1, expense.getExpenseTitle());
            // Setting Expense Amount
            ps.setDouble(2, expense.getExpenseAmount());
            // Setting Expense Date
            ps.setDate(3,java.sql.Date.valueOf( expense.getExpenseDate()));
            // Setting Expense Type
            ps.setString(4, expense.getExpenseType());

           int rows = ps.executeUpdate();

           return rows > 0;




        }catch(SQLException e){
            System.out.println("DB Error: " + e.getMessage());
            return false;
        }


    }

}
