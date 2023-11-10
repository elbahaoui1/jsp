<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Form</title>
</head>
<body>
    <form action="EmployeController" method="post">
        <!-- Input fields for user to enter data -->
        <label for="employeeName">Employee Name:</label>
        <input type="text" id="employeeName" name="employeeName" required><br>

        <label for="employeeLastName">Employee Last Name:</label>
        <input type="text" id="employeeLastName" name="employeeLastName" required><br>

        <label for="employeeSalary">Employee Salary:</label>
        <input type="text" id="employeeSalary" name="employeeSalary" required><br>

        <!-- Button to submit the form -->
        <button type="submit">Send</button>
    </form>
    
</body>
</html>
