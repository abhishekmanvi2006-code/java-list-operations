package com.employee;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int empno = Integer.parseInt(request.getParameter("empno"));
        String empname = request.getParameter("empname");
        int salary = Integer.parseInt(request.getParameter("salary"));

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3309/employee", "root", "Abhishek@123");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Emp VALUES (?, ?, ?)");

            ps.setInt(1, empno);
            ps.setString(2, empname);
            ps.setInt(3, salary);

            ps.executeUpdate();

            out.println("<h2>Record Inserted Successfully</h2>");

            out.println("<h3>Salary Report</h3><hr>");

            PreparedStatement ps2 = con.prepareStatement(
                    "SELECT * FROM Emp WHERE Emp_Name LIKE 'R%'");

            ResultSet rs = ps2.executeQuery();

            int total = 0;

            while (rs.next()) {

                out.println("Emp_No : " + rs.getInt("Emp_NO") + "<br>");
                out.println("Emp_Name: " + rs.getString("Emp_Name") + "<br>");
                out.println("Basic : " + rs.getInt("Basicsalary") + "<br><hr>");

                total += rs.getInt("Basicsalary");
            }

            out.println("<h3>Grand Salary: " + total + "</h3>");

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e);
        }
    }
}