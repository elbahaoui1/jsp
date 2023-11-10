package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.IdaoLocal;
import entities.Employe;

@WebServlet("/EmployeController")
public class EmployeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private IdaoLocal<Employe> dao;

    public EmployeController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve all employees from the database using the DAO
            List<Employe> employees = dao.findAll();
            System.out.println("Result of dao.findAll(): " + employees);
            // Set the list of employees as a request attribute
            request.setAttribute("employees", employees);

            // Forward to the JSP page to display the list of employees
            request.getRequestDispatcher("employeelist.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Add this line to print the exception stack trace
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve input from the form
        String employeeName = request.getParameter("employeeName");
        String employeeLastName = request.getParameter("employeeLastName");
        String employeeSalaryStr = request.getParameter("employeeSalary");

        // Validate and convert the salary to a double
        double employeeSalary = 0.0;
        try {
            employeeSalary = Double.parseDouble(employeeSalaryStr);
        } catch (NumberFormatException e) {
            // Handle the exception if the salary is not a valid double
            // You may want to display an error message to the user
            e.printStackTrace();
        }

        // Create a new Employe instance with the entered data
        Employe newEmployee = new Employe(employeeName, employeeLastName, employeeSalary);

        // Save the new employee to the database using the DAO
        dao.create(newEmployee);

        // Redirect to the list page to display the updated list of employees
        response.sendRedirect("employeelist.jsp");
    }
}
