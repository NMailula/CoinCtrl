package model;

import java.time.LocalDate;

public class Expense {

    private String ExpenseTitle;
    private Double ExpenseAmount;
    private LocalDate  ExpenseDate;
    private String ExpenseType;


    public Expense() {
        this.ExpenseTitle = ExpenseTitle;
        this.ExpenseAmount = ExpenseAmount;
        this.ExpenseType = ExpenseType;
        this.ExpenseDate = LocalDate.now();
    }

    // Getters and Setters
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
