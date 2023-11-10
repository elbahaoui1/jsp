<%@ page import="java.util.List" %>
<%@ page import="entities.Employe" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <% 
            // Retrieve the list of employees from the request attribute
            @SuppressWarnings(value = "unchecked")
            List<Employe> employees = (List<Employe>) request.getAttribute("employees");

            // Print the size of the list
            System.out.println("Number of employees: " + (employees != null ? employees.size() : 0));

            // Check if the list is not null before iterating
            if (employees != null) {
                Iterator<Employe> iterator = employees.iterator();
                while(iterator.hasNext()) {
                    Employe employee = iterator.next();
            %>
                    <tr>
                        <td><%= employee.getId() %></td>
                        <td><%= employee.getNom() %></td>
                        <td><%= employee.getPrenom() %></td>
                        <td><%= employee.getSalaire() %></td>
                    </tr>
            <% 
                }
            } else {
                // Handle the case where the list is null (e.g., display a message)
                %>
                <tr>
                    <td colspan="4">No employees found</td>
                </tr>
            <% } %>

        </tbody>
    </table>
</body>
</html>
