package model;

import java.time.LocalDate;

public class Income {


public String  IncomeTitle;
public double ExpectedAmount;
public double ActualAmount;

LocalDate IncomeDate;

public Income (String IncomeTitle, double ExpectedAmount,double ActualAmount, LocalDate IncomeDate) {
    this.IncomeTitle = IncomeTitle;
    this.ExpectedAmount = ExpectedAmount;
    this.ActualAmount = ActualAmount;
    this.IncomeDate = LocalDate.now();

}


}
