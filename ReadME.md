# controller.CoinCtrl

**Summary of Project**

CoinCtrl is intended to be a financial journaling application, developed to allow users to record and read their financial activities on a monthly and daily basis.
This application serves as **an advancement and encouragement of personal financial literacy**, for users to have 'control' of their financial activities. 

---

## Application Overview

## **System's functions**

**Features**
- Terminal-based interface
- MySQL database integration via JDBC
- Multiple functionalities (Including reading and writing to and from the database)
- Basic UI
---

## Technologies Used

Technology    | Purpose
--------------|--------------
Java (JDK 8+) | Application logic
MySQL         | Database
JDBC          | Database Connectivity
IntelliJ IDEA | Development Environment
SQL           | Data management

---

## Project Structures
````
CoinCtrl/_
         |
         src/
            |
            |____ controller/__
            |                  |___ CoinCtrl.java  
            |
            |
            |____ Repository/__
            |                  |___ ExpenseRepository.java
            |                  |___ IncomeRepository.java
            |                  
            |
            |____ Service/__
            |               |___ ExpenseService.java
            |               |___ IncomeService.java
            |
            |
            |____ model/__
            |            |___ Expense.java
            |            |___ Income.java
            |
            |
            |___ utils/__
            |           |
            |           |___ CSVWriter.java
            |
            |___ ReadME.md
````
--- 

## Class Overview

## **controller.CoinCtrl.java**

This class serves as the main class which initiates user interaction with the controller.CoinCtrl logic.
The user interacts with a menu-screen, which will appropriately lead the user to the 'back-end' logic;


- **main()**

This method first runs a data backing-up operations (ExpenseDocWriter() ---> DBAdmin.java), which backs ups data from the database into CSV files. This version of application loads expense and income data into 2 separate CSV files.
This method serves as the main menu (start screen UI in the terminal), where the user will pick 1 of 3 options; Income, Expenses and Overall Finances. 
In this version of controller.CoinCtrl, overall finances option is unavailable (not yet developed).

- **Expenses()**

This method presents a sub-menu screen where the user can choose whether they would like to record or review expense data (options include reviewing all data, or specified data type or time).


- **Income()**

  This method presents a sub-menu screen where the user can choose whether they would like to record or review income data (options include reviewing all data or specified time).

---

## **DBAdmin.java**

The main purpose of this class is to process data from the user and database. 
This class allows the application to import or upload specified data values.

- **DailyExpenseRecorder()**

THis method handles the logic to record user-provided expense data into the database

- **DEDataImport()**

This method handles the logic to import **ALL** expense data and display it on the terminal window.

- **ExpensesByTime()**

This method handles the logic to import expense data within a specified timeframe (month).

- **ExpensesByType()**

THis method handles the logic to import all expense data  with a specified expense type (Fixed or  Variable).

- **ExpensesByMonthType()**

This method handles the logic to import time and type-specified expense data from the database and display it on the terminal window

- **ExpenseDocWriter()**

This method handles the logic to back up all expense data from the database.
The expense data is written into a CSV file.

- **MonthlyIncomeRecorder()**

This method handles the logic to upload user-provided income data into the database

- **ImportIncomeData()**

This method contains logic to import **ALL** income data from the database

- **IncomeByTime()**

This method contains the logic to import time-specified data from the MySQL database 

- **IncomeDocWriter()**

This method handles the logic to back up all income data from the database.
The income data is written into a CSV file.

---

## **DBConnection.java**

This class manages the connection between the application and the MySQL database through the use of the JDBC library.

- **getConnection()**

This method creates the Java-Database connection with the use of specified DB credentials.

---

## **FinancialOperations.java**

This class contains the logic to process multiple inputs in relation to the user's desired operations.
This class handles the logic to review or add expense/income data. 

**Expenses Logic**

The expenses logic in this class include reviewing expenses by time, where the user is asked to specify the desired expense data to import from the DB by the month.
The class also allows a user to review their expenses by specifying type of expense (i.e. Variable or fixed expenses).
The class features a method to allows users to review expenses specified by both time and type of expenses. Additionally, the class allows users to record (add) expense data into the database.

- **ReviewExpensesByTime()**

This method allows users to import expenses data within a specified (month) time frame. 
Here, the user is prompted to provide a string input (name of a month), and upon submission, the input will then be parsed to the appropriate logic **(ExpensesByTime() method)** in the DBAdmin.java class.

- **ReviewExpensesByType()**

This method allows users to import expense data specified by type, i.e. **Variable or Fixed** expense data.
In this method, the user will be prompted to choose whether to import expense data by type, i.e. Fixed or Variable expenses.
Upon specification of desired expense type, the application will parse the input data to the appropriate method **(ExpensesByType() method)** in the DBAdmin.java class.

- **ReviewExpensesByTNT()**

This method allows users to review expense data specified with 2 parameters, a month value and expense-type value, both of which are inputs provided by the user.
User's inputs will then be handled by the logic **(ExpenseByMonthType() method)**.

- **AddExpenses()**

This method's purpose is to allow users to add expense data such at title of expense and amount spent.


**Income Logic**

The income logic in this clas includes reviewing and adding income data. 
The class allows users to review income data within a user-specified timeframe (month)

- **ReviewIncomeByTime()**

This method contains the logic to process user's input data to determine the timeframe of Income data they would like to review.
Users will provide input in the form of a month (String value).

- **AddIncome()**

This method allows users to record their income data into the database.
The user-provided data includes the source of income (or title), the expected amount and actual amount received.
THe Database handles the mathematical logic to calculate the difference between expected and actual income data.


---

## Contributions

- **Project author: Nathi Mailula**
- **Developed: May 2026**
