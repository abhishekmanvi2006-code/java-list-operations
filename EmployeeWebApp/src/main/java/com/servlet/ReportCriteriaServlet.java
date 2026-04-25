package com.servlet;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;


public class ReportCriteriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String type = req.getParameter("type");

        if (type != null && !type.isBlank()) {
            resp.sendRedirect("report_form.jsp?reportType=" + type);
        } else {
            resp.sendRedirect("report_form.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}