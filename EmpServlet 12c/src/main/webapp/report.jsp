<%@ page import="java.sql.*" %>

<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>
<h2>Salary Report</h2>
<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

<%
int total = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3309/Employee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
        "empuser",
        "1234"
    );

    // 🔥 CHANGED QUERY (shows all records)
    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM Emp"
    );

    ResultSet rs = ps.executeQuery();

    while(rs.next()) {

        int empno = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int salary = rs.getInt("Basicsalary");

        total += salary;
%>

Emp_No : <%= empno %> <br>
Emp_Name: <%= name %> <br>
Basic : <%= salary %> <br>

<h3>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h3>

<%
    }
%>

<h3>Total Salary : <%= total %></h3>

<%
    con.close();

} catch(Exception e) {
    out.println("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
}
%>