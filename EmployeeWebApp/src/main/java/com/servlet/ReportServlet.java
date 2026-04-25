package com.servlet;

import com.dao.EmployeeDAO;
import com.model.Employee;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


public class ReportServlet extends HttpServlet {

    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String         reportType  = req.getParameter("reportType");
        List<Employee> results     = null;
        String         reportTitle = "";
        String         reportDesc  = "";

        try {
            switch (reportType) {

                case "1": {
                    String letter = req.getParameter("nameLetter");
                    if (letter == null || letter.isBlank()) {
                        req.getSession().setAttribute("errorMsg",
                            "Please enter a letter.");
                        resp.sendRedirect("report_form.jsp");
                        return;
                    }
                    results     = dao.getEmployeesByNameLetter(letter.trim());
                    reportTitle = "Employees Whose Name Starts With '"
                                  + letter.toUpperCase() + "'";
                    reportDesc  = "Showing employees with names beginning with "
                                  + letter.toUpperCase();
                    break;
                }

                case "2": {
                    String yearsStr = req.getParameter("yearsOfService");
                    if (yearsStr == null || yearsStr.isBlank()) {
                        req.getSession().setAttribute("errorMsg",
                            "Please enter number of years.");
                        resp.sendRedirect("report_form.jsp");
                        return;
                    }
                    int years   = Integer.parseInt(yearsStr.trim());
                    results     = dao.getEmployeesByYearsOfService(years);
                    reportTitle = "Employees With " + years + "+ Years of Service";
                    reportDesc  = "Showing employees who joined "
                                  + years + " or more years ago";
                    break;
                }

                case "3": {
                    String salStr = req.getParameter("salaryThreshold");
                    if (salStr == null || salStr.isBlank()) {
                        req.getSession().setAttribute("errorMsg",
                            "Please enter a salary amount.");
                        resp.sendRedirect("report_form.jsp");
                        return;
                    }
                    BigDecimal salary = new BigDecimal(salStr.trim());
                    results     = dao.getEmployeesAboveSalary(salary);
                    reportTitle = "Employees Earning More Than Rs." + salary;
                    reportDesc  = "Showing employees with Basic Salary above Rs."
                                  + salary;
                    break;
                }

                default:
                    req.getSession().setAttribute("errorMsg",
                        "Invalid report type selected.");
                    resp.sendRedirect("report_form.jsp");
                    return;
            }

            req.setAttribute("reportResults", results);
            req.setAttribute("reportTitle",   reportTitle);
            req.setAttribute("reportDesc",    reportDesc);
            req.setAttribute("reportType",    reportType);
            req.getRequestDispatcher("report_result.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            req.getSession().setAttribute("errorMsg",
                "Invalid input: " + e.getMessage());
            resp.sendRedirect("report_form.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("report_form.jsp");
    }
}