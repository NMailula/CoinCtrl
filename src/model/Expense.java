package model;

import java.time.LocalDate;

public class Expense {

    public String ExpenseTitle;
    public String ExpenseType;
    public double ExpenseAmount;

    LocalDate ExpenseDate;

    public Expense (String ExpenseTitle, String ExpenseType, double ExpenseAmount) {
        this.ExpenseTitle = ExpenseTitle;
        this.ExpenseType = ExpenseType;
        this.ExpenseAmount = ExpenseAmount;
        this.ExpenseDate = LocalDate.now();
    }


}
