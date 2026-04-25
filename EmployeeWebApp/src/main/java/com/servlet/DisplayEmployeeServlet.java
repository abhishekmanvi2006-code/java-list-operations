package com.servlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class DisplayEmployeeServlet extends HttpServlet {

    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String empnoStr = req.getParameter("empno");

        if (empnoStr != null && !empnoStr.isBlank()) {

            try {
                int      empno = Integer.parseInt(empnoStr.trim());
                Employee emp   = dao.getEmployeeByEmpno(empno);

                if (emp != null) {
                    req.setAttribute("employee", emp);
                    req.setAttribute("mode", "single");
                } else {
                    req.setAttribute("errorMsg",
                        "No employee found with Empno: " + empno);
                    req.setAttribute("mode", "notfound");
                }

            } catch (NumberFormatException e) {
                req.setAttribute("errorMsg", "Invalid Empno format.");
                req.setAttribute("mode", "notfound");
            }

        } else {
            List<Employee> employees = dao.getAllEmployees();
            req.setAttribute("employees", employees);
            req.setAttribute("mode", "all");
        }

        req.getRequestDispatcher("empdisplay.jsp").forward(req, resp);
    }
}