# CoinCtrl

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
CoinCtrl 
||
|| === Screenshots
||
|| === src
||     || === CoinCtrl.java
||     || === DBAdmin.java
||     || === DBConnection.java
||     || === FinancialOperations.java  
||
||
|| === ReadME.md
|| === expenses_export.csv
|| === income_export.csv
````
--- 

## Class Overview

**CoinCtrl.java**

This class serves as the main class which initiates user interaction with the CoinCtrl logic.
The user interacts with a menu-screen, which will appropriately lead the user to the 'back-end' logic;


- **main() method**

This method first runs a data backing-up operations (ExpenseDocWriter() ---> DBAdmin.java), which backs ups data from the database into CSV files. This version of application loads expense and income data into 2 separate CSV files.
This method serves as the main menu (start screen UI in the terminal), where the user will pick 1 of 3 options; Income, Expenses and Overall Finances. 
In this version of CoinCtrl, overall finances option is unavailable (not yet developed).

- **Expenses()**

This method presents a sub-menu screen where the user can choose whether they would like to record or review expense data (options include reviewing all data, or specified data type or time).


- **Income()**
- 
  This method presents a sub-menu screen where the user can choose whether they would like to record or review income data (options include reviewing all data or specified time).

---

**DBAdmin.java**

The main purpose of this class is to process data from the user and database. 
This class allows the application to import or upload specified data values.

- **DailyExpenseRecorder()**


- **DEDataImport()**


- **ExpensesByTime()**


- **ExpensesByType()**


- **ExpensesByMonthType()**


- **ExpenseDocWriter()**


- **MonthlyIncomeRecorder()**


- **ImportIncomeData()**


- **IncomeByTime()**


- **IncomeDocWriter()**


---

**DBConnection.java**

This class manages the connection between the application and the MySQL database through the use of the JDBC library.

- **getConnection()**
This method creates the Java-Database connection with the use of specified DB credentials.

---

**FinancialOperations.java**

This class contains the logic to process multiple inputs in relation to the user's desired operations.
This class handles the logic to review or add expense/income data. 

**Expenses Logic**

The expenses logic in this class include reviewing expenses by time, where the user is asked to specify the desired expense data to import from the DB by the month.
The class also allows a user to review their expenses by specifying type of expense (i.e. Variable or fixed expenses).
The class features a method to allows users to review expenses specified by both time and type of expenses. Additionally, the class allows users to record (add) expense data into the database.

- **ReviewExpensesByTime()**

This method allows users to import expenses data within a specified (month) time frame. Here, the user is prompted to provide a string input (name of a month)

- **ReviewExpensesByType()**


- **ReviewExpensesByTNT()**


- **AddExpenses()**


**Income Logic**


- **ReviewIncomeByTime()**


- **AddIncome()**



---

## **Diagram of CoinCtrl's Operations (summarized)**
````
CoinCtrl.java |==> main()
               ||
               ||====> Expenses() 
               ||              ||
               ||              ||==========>| FinancialOperations.java |================================================>||                                                    
               ||                                             ||==> ReviewExpensesByTime() =============================>||                     ||===> DailyExpenseRecorder()
               ||                                             ||==> ReviewExpensesByType() =============================>||                     ||===> DEDataImport()
               ||                                             ||==> ReviewExepnsesByTNT() ==============================>||                     ||===> ExpensesByTime()
               ||                                             ||==> AddExpenses()=======================================>||=> |DBAdmin.java|====||===> ExpensesByType()
               ||                                             ||                                                         ||                     ||===> ExpensesByMonthType()
               ||                                             ||==> ReviewIncomeByTime()  ==============================>||                     ||===> ExpenseDocWriter()
               ||                                             ||==> AddIncome()=========================================>||                     ||===> MonthlyIncomeRecorder()
               ||                                             ||                                                         ||                     ||===> ImportIncomeData()
               ||===> Income()================================|| ========================================================||                     ||===> IncomeByTime()
                                                                                                                                                ||===> IncomeDocWriter()
````






## Contributions

- **Project author: Nathi Mailula**
- **Developed: May 2026**