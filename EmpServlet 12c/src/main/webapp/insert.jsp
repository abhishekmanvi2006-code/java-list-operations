<%@ page import="java.sql.*" %>

<%
String empnoStr = request.getParameter("empno");
String empname = request.getParameter("empname");
String salaryStr = request.getParameter("salary");

if(empnoStr != null && empname != null && salaryStr != null) {

    int empno = Integer.parseInt(empnoStr);
    int salary = Integer.parseInt(salaryStr);

    try {
        // Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // DB connection (PORT 3309 ✅)
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3309/Employee?useSSL=false&serverTimezone=UTC",
            "empuser",   // ⚠️ use new user (NOT root)
            "1234"
        );

        // Insert query
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Emp (Emp_NO, Emp_Name, Basicsalary) VALUES (?, ?, ?)"
        );

        ps.setInt(1, empno);
        ps.setString(2, empname);
        ps.setInt(3, salary);

        int i = ps.executeUpdate();

        if(i > 0) {
            out.println("<h3 style='color:green'>Record Inserted Successfully</h3>");
        } else {
            out.println("<h3 style='color:red'>Insert Failed</h3>");
        }

        con.close();

    } catch(Exception e) {
        out.println("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
    }
}
%>

<br><a href="index.html">Go Back</a>