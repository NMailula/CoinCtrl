package service;


import model.*;
import repository.*;
import controller.*;

import java.time.LocalDate;

//
public class ExpenseService {

    static ExpenseRepository repo = new ExpenseRepository();
    Expense expense = new Expense();


    //
    public void InputValidation(String ExpenseTitle, double ExpenseAmount, String ExpenseType, LocalDate ExpenseDate){

        if (ExpenseTitle.matches("[a-zA-Z]+") || ExpenseAmount > 0) {

            // setting
            expense.setExpenseTitle(ExpenseTitle);
            expense.setExpenseType(ExpenseType);
            //
            expense.setExpenseDate(ExpenseDate);
            expense.setExpenseAmount(ExpenseAmount);

        } else {
            System.out.println("Error: Invalid Input");
        }

        //
        boolean saved = repo.saveExpense(expense);
        System.out.println(saved ? "Expense Saved" : "Expense Not Saved");


    }



}
