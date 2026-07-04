package service;


import model.*;
import repository.*;
import controller.*;

import java.time.LocalDate;

//
public class ExpenseService {

    static ExpenseRepository repo = new ExpenseRepository();
    Expense expense = new Expense();



   public void InputValidation(String ExpenseTitle, double ExpenseAmount, String ExpenseType, LocalDate ExpenseDate) {


       if (ExpenseAmount > 0 || ExpenseTitle.matches("[a-zA-Z]+")) {

           //
           expense.setExpenseTitle(ExpenseTitle);
           expense.setExpenseType(ExpenseType);
           //
           expense.setExpenseAmount(ExpenseAmount);
           expense.setExpenseDate(ExpenseDate);

       } else {
           System.out.println("*** Error: Invalid input ***");
           CoinCtrl.addExpenseUI();
       }

       boolean saved = repo.saveExpense(expense);
       System.out.println(saved ? "Expense saved" : "Expense not Saved");

   }

}
