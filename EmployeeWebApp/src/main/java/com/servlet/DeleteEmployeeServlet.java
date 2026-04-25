package com.servlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;


public class DeleteEmployeeServlet extends HttpServlet {

    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String empnoStr = req.getParameter("empno");

        if (empnoStr == null || empnoStr.isBlank()) {
            resp.sendRedirect("empdelete.jsp");
            return;
        }

        try {
            int      empno = Integer.parseInt(empnoStr.trim());
            Employee emp   = dao.getEmployeeByEmpno(empno);

            if (emp != null) {
                req.setAttribute("employee", emp);
                req.getRequestDispatcher("empdelete.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("errorMsg",
                    "No employee found with Empno: " + empno);
                resp.sendRedirect("empdelete.jsp");
            }

        } catch (NumberFormatException e) {
            req.getSession().setAttribute("errorMsg", "Invalid Empno format.");
            resp.sendRedirect("empdelete.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int     empno   = Integer.parseInt(req.getParameter("empno").trim());
            boolean success = dao.deleteEmployee(empno);

            if (success) {
                req.getSession().setAttribute("successMsg",
                    "Employee " + empno + " deleted successfully.");
            } else {
                req.getSession().setAttribute("errorMsg",
                    "Delete failed. Empno " + empno + " not found.");
            }

        } catch (Exception e) {
            req.getSession().setAttribute("errorMsg", "Error: " + e.getMessage());
        }

        resp.sendRedirect("empdelete.jsp");
    }
}