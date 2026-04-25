package com.servlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;


public class AddEmployeeServlet extends HttpServlet {

    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            // Read each parameter safely with null check
            String empnoStr  = req.getParameter("empno");
            String empName   = req.getParameter("empName");
            String dojStr    = req.getParameter("doj");
            String gender    = req.getParameter("gender");
            String salaryStr = req.getParameter("bsalary");

            // Check if any field is null or empty
            if (empnoStr == null || empnoStr.isEmpty() ||
                empName  == null || empName.isEmpty()  ||
                dojStr   == null || dojStr.isEmpty()   ||
                gender   == null || gender.isEmpty()   ||
                salaryStr== null || salaryStr.isEmpty()) {

                req.getSession().setAttribute("errorMsg",
                    "All fields are required. Please fill in every field.");
                resp.sendRedirect("empadd.jsp");
                return;
            }

            // Parse values
            int        empno  = Integer.parseInt(empnoStr.trim());
            Date       doj    = Date.valueOf(dojStr.trim());
            BigDecimal salary = new BigDecimal(salaryStr.trim());

            // Create employee object
            Employee emp = new Employee(
                empno,
                empName.trim(),
                doj,
                gender.trim(),
                salary
            );

            // Save to database
            boolean success = dao.addEmployee(emp);

            if (success) {
                req.getSession().setAttribute("successMsg",
                    "Employee " + empno + " added successfully!");
            } else {
                req.getSession().setAttribute("errorMsg",
                    "Failed to add employee. Empno " + empno + " may already exist.");
            }

        } catch (IllegalArgumentException e) {
            req.getSession().setAttribute("errorMsg",
                "Invalid date format. Please use the date picker.");
        } catch (Exception e) {
            req.getSession().setAttribute("errorMsg",
                "Error: " + e.getMessage());
        }

        resp.sendRedirect("empadd.jsp");
    }
}