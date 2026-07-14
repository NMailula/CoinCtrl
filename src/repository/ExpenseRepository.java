package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.*;


public class ExpenseRepository {

    private DBConnection sbCon = new DBConnection();


    public boolean saveExpense(Expense expense) {

        String sql = "INSERT INTO expenses (Title, Amount, Transaction_Date, Type) VALUES (?, ?, ?, ?)";

        try (Connection con = sbCon.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, expense.getExpenseTitle());
            pstmt.setDouble(2, expense.getExpenseAmount());
            pstmt.setDate(3, java.sql.Date.valueOf(expense.getExpenseDate()));
            pstmt.setString(4, expense.getExpenseType());

            int rows =  pstmt.executeUpdate();

            return  rows > 0;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }





}
