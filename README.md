# Employee-Managment-and-Payroll-Application

## Overview 

The Payroll Application has been implemented in Java with proper Front-end and Back-end Development.
The main purpose of the software is to generate accurate salaries of employees based on their shift and total working minutes for the month. It is also capable of managing employees’ informations.
The Software is linked to a local MySQL database that stores all the information of employees and their salaries that have been generated for each month.

The software is reliant upon reading necessary information related to employees and their attendances from an Excel Sheet. 
The excel sheet can then be uploaded in the system in order to generate accurate salaries.

To run the code, install any Java IDE like Eclipse or NetBeans and MySQL. To compile the code, clone the repository and open the the project file in IDE. Since the application is connected to a local database, update the login credentials in the URL of getConnection() method of database in DB_Crud File in order to connect it to your local MySQL.

## Main Working of the Software 

The software reads the monthly attendance information of the employees from an excel sheet and calculates the total working minutes of each employee for the month. Then, based on the gross salary, working minutes and shift type (A, B or C) of the employee, it calculates the earned salary and subtracts the total deductions amount to calculate the net salary of the employees. These salaries are then presented in a table to the user and are stored in the Application’s database so that they can be viewed later also.

## Main Page Interface 

<img width="500" alt="Screenshot 2021-06-08 at 12 11 14 PM" src="https://user-images.githubusercontent.com/83071313/121143655-b8512380-c856-11eb-9b31-b47af40d16b3.png">

## Salary Sheet Intreface 

<img width="899" alt="Screenshot 2021-06-08 at 12 11 33 PM" src="https://user-images.githubusercontent.com/83071313/121145722-ae302480-c858-11eb-9c16-f665a7b29445.png">

## Employee Salary Data Interface

<img width="899" alt="Screenshot 2021-06-08 at 12 11 46 PM" src="https://user-images.githubusercontent.com/83071313/121146051-fc452800-c858-11eb-8c1a-b2e5555e3f8e.png">

## Employee Information Interface

<img width="880" alt="Screenshot 2021-06-08 at 12 12 03 PM" src="https://user-images.githubusercontent.com/83071313/121146280-357d9800-c859-11eb-825b-42803dd2cab4.png">
