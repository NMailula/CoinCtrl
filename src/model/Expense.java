package model;

import java.sql.Date;
import java.time.LocalDate;

public class Expense {

    public String ExpenseTitle;
    public String ExpenseType;
    public double ExpenseAmount;

    private LocalDate ExpenseDate;


    public Expense(String ExpenseTitle, double ExpenseAmount, String ExpenseType) {
        this.ExpenseTitle = ExpenseTitle;
        this.ExpenseType = ExpenseType;
        this.ExpenseAmount = ExpenseAmount;
        this.ExpenseDate = LocalDate.now();
    }

    // Getters + setters
    public String getExpenseTitle(){
        return ExpenseTitle;
    }

    public void setExpenseTitle(String ExpenseTitle){
        this.ExpenseTitle = ExpenseTitle;
    }


    public String getExpenseType(){
        return ExpenseType;
    }

    public void setExpenseType(String ExpenseType){
        this.ExpenseType = ExpenseType;
    }

    public double getExpenseAmount(){
        return ExpenseAmount;
    }

    public void setExpenseAmount(double ExpenseAmount){
        this.ExpenseAmount = ExpenseAmount;
    }

    public LocalDate getExpenseDate(){
        return ExpenseDate;
    }

    public void setExpenseDate(LocalDate ExpenseDate){
        this.ExpenseDate = ExpenseDate;
    }



}
