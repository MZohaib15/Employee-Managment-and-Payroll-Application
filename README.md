# Employee-Managment-and-Payroll-Application

## Overview :-

The Payroll Application has been implemented in Java with proper Front-end and Back-end Development.
The main purpose of the software is to generate accurate salaries of employees based on their shift and total working minutes for the month. It is also capable of managing employees’ informations.
The Software is linked to a local MySQL database that stores all the information of employees and their salaries that have been generated for each month.

The software is reliant upon reading necessary information related to employees and their attendances from an Excel Sheet. 
The excel sheet can then be uploaded in the system in order to generate accurate salaries.

To run the code, install any Java IDE like Eclipse or NetBeans and MySQL. To compile the code, clone the repository and open the the project file in IDE. Since the application is connected to a local database, update the login credentials in the URL of getConnection() method of database in DB_Crud File in order to connect it to your local MySQL.

## Main Working of the Software :-
The software reads the monthly attendance information of the employees from an excel sheet and calculates the total working minutes of each employee for the month. Then, based on the gross salary, working minutes and shift type (A, B or C) of the employee, it calculates the earned salary and subtracts the total deductions amount to calculate the net salary of the employees. These salaries are then presented in a table to the user and are stored in the Application’s database so that they can be viewed later also.

## Main Page Interface :-

