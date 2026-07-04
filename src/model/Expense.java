package model;

import java.time.LocalDate;

public class Expense {

    private String ExpenseTitle;
    private String ExpenseType;
    private double ExpenseAmount;

    private LocalDate ExpenseDate;


    public Expense() {
        this.ExpenseTitle = ExpenseTitle;
        this.ExpenseType = ExpenseType;
        this.ExpenseAmount = ExpenseAmount;
        this.ExpenseDate = LocalDate.now();
    }

    // Getters + setters
    public String getExpenseTitle() { return ExpenseTitle;}
    public String setExpenseTitle(String ExpenseTitle) {this.ExpenseTitle = ExpenseTitle;
        return ExpenseTitle;
    }

    public Double getExpenseAmount() { return ExpenseAmount;}
    public void setExpenseAmount(Double ExpenseAmount) {this.ExpenseAmount = ExpenseAmount;}


    public LocalDate getExpenseDate() { return ExpenseDate;}
    public void setExpenseDate(LocalDate ExpenseDate) {this.ExpenseDate = ExpenseDate;}


    public String getExpenseType() { return ExpenseType;}
    public void setExpenseType(String ExpenseType) {this.ExpenseType = ExpenseType;}



}
