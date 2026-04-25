<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Employee" %>
<%
    Employee emp      = (Employee) request.getAttribute("employee");
    String successMsg = (String) session.getAttribute("successMsg");
    String errorMsg   = (String) session.getAttribute("errorMsg");
    session.removeAttribute("successMsg");
    session.removeAttribute("errorMsg");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Delete Employee | EMS</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<nav class="navbar">
    <a href="index.jsp" class="brand">&#128188; EMS Portal</a>
    <nav>
        <a href="empadd.jsp">Add</a>
        <a href="empupdate.jsp">Update</a>
        <a href="empdelete.jsp" class="active">Delete</a>
        <a href="DisplayEmployeeServlet">Display All</a>
        <a href="report_form.jsp">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">

    <!-- Step 1: Enter Empno to search -->
    <div class="card">
        <div class="card-title">&#128465;&#65039; Delete Employee</div>
        <div class="card-subtitle">Enter Employee No. to search for the record before deleting.</div>

        <% if (successMsg != null) { %><div class="alert alert-success">&#10003; <%= successMsg %></div><% } %>
        <% if (errorMsg   != null) { %><div class="alert alert-danger">&#9888; <%= errorMsg %></div><% } %>

        <form action="DeleteEmployeeServlet" method="get" style="display:flex;gap:12px;align-items:flex-end;">
            <div class="form-group" style="flex:1; margin-bottom:0;">
                <label for="empno">Employee No.</label>
                <input type="number" id="empno" name="empno" class="form-control" placeholder="e.g. 1001" required min="1"/>
            </div>
            <button type="submit" class="btn btn-primary">Search &rarr;</button>
            <a href="index.jsp" class="btn btn-secondary">&#8592; Back</a>
        </form>
    </div>

    <!-- Step 2: Confirmation card shown after fetch -->
    <% if (emp != null) { %>
    <div class="card" style="border:2px solid #fecaca;">
        <div class="card-title" style="color:#dc2626;">&#9888; Confirm Deletion</div>
        <div class="card-subtitle">Review the record below. This action cannot be undone.</div>

        <table style="margin-bottom:24px;">
            <thead><tr>
                <th>Emp No.</th><th>Name</th><th>Date of Joining</th><th>Gender</th><th>Basic Salary</th>
            </tr></thead>
            <tbody><tr>
                <td><strong><%= emp.getEmpno() %></strong></td>
                <td><%= emp.getEmpName() %></td>
                <td><%= emp.getDoj() %></td>
                <td>
                    <span class="badge badge-<%= emp.getGender().toLowerCase() %>">
                        <%= emp.getGender() %>
                    </span>
                </td>
                <td>&#8377; <%= emp.getBsalary() %></td>
            </tr></tbody>
        </table>

        <form action="DeleteEmployeeServlet" method="post"
              onsubmit="return confirm('Are you absolutely sure you want to delete Emp #<%= emp.getEmpno() %>?')">
            <input type="hidden" name="empno" value="<%= emp.getEmpno() %>"/>
            <div style="display:flex; gap:12px;">
                <button type="submit" class="btn btn-danger">&#128465;&#65039; Yes, Delete</button>
                <a href="empdelete.jsp" class="btn btn-secondary">&#10006; Cancel</a>
            </div>
        </form>
    </div>
    <% } %>

</div>
</body>
</html>
