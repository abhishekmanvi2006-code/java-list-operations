package com.servlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;


public class UpdateEmployeeServlet extends HttpServlet {

    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String empnoStr = req.getParameter("empno");

        if (empnoStr == null || empnoStr.isBlank()) {
            resp.sendRedirect("empupdate.jsp");
            return;
        }

        try {
            int      empno = Integer.parseInt(empnoStr.trim());
            Employee emp   = dao.getEmployeeByEmpno(empno);

            if (emp != null) {
                req.setAttribute("employee", emp);
                req.getRequestDispatcher("empupdate.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("errorMsg",
                    "No employee found with Empno: " + empno);
                resp.sendRedirect("empupdate.jsp");
            }

        } catch (NumberFormatException e) {
            req.getSession().setAttribute("errorMsg", "Invalid Empno format.");
            resp.sendRedirect("empupdate.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            int        empno   = Integer.parseInt(req.getParameter("empno").trim());
            String     empName = req.getParameter("empName").trim();
            Date       doj     = Date.valueOf(req.getParameter("doj").trim());
            String     gender  = req.getParameter("gender").trim();
            BigDecimal salary  = new BigDecimal(req.getParameter("bsalary").trim());

            Employee emp     = new Employee(empno, empName, doj, gender, salary);
            boolean  success = dao.updateEmployee(emp);

            if (success) {
                req.getSession().setAttribute("successMsg",
                    "Employee " + empno + " updated successfully!");
            } else {
                req.getSession().setAttribute("errorMsg",
                    "Update failed. Empno " + empno + " not found.");
            }

        } catch (Exception e) {
            req.getSession().setAttribute("errorMsg", "Error: " + e.getMessage());
        }

        resp.sendRedirect("empupdate.jsp");
    }
}