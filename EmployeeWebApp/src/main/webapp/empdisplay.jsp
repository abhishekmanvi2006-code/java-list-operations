<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Employee, java.util.List" %>
<%
    Employee       emp       = (Employee)       request.getAttribute("employee");
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
    String mode              = (String)         request.getAttribute("mode");
    String errorMsg          = (String)         request.getAttribute("errorMsg");
    if (mode == null) mode   = "search";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Display Employee | EMS</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<nav class="navbar">
    <a href="index.jsp" class="brand">&#128188; EMS Portal</a>
    <nav>
        <a href="empadd.jsp">Add</a>
        <a href="empupdate.jsp">Update</a>
        <a href="empdelete.jsp">Delete</a>
        <a href="DisplayEmployeeServlet" class="active">Display All</a>
        <a href="report_form.jsp">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">

    <!-- Search card -->
    <div class="card">
        <div class="card-title">&#128203; Display Employee</div>
        <div class="card-subtitle">Search by Employee No. for a single record, or click "Show All" for the full list.</div>

        <% if (errorMsg != null) { %><div class="alert alert-danger">&#9888; <%= errorMsg %></div><% } %>

        <form action="DisplayEmployeeServlet" method="get"
              style="display:flex; gap:12px; align-items:flex-end; flex-wrap:wrap;">
            <div class="form-group" style="flex:1; margin-bottom:0; min-width:180px;">
                <label for="empno">Employee No.</label>
                <input type="number" id="empno" name="empno" class="form-control"
                       placeholder="e.g. 1001" min="1"/>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
            <a href="DisplayEmployeeServlet" class="btn btn-secondary">Show All</a>
            <a href="index.jsp"             class="btn btn-secondary">&#8592; Home</a>
        </form>
    </div>

    <!-- Single employee result -->
    <% if ("single".equals(mode) && emp != null) { %>
    <div class="card">
        <div class="card-title" style="margin-bottom:20px;">
            Employee Record &mdash; #<%= emp.getEmpno() %>
        </div>
        <table>
            <thead><tr>
                <th>Emp No.</th><th>Name</th><th>Date of Joining</th><th>Gender</th><th>Basic Salary</th><th>Actions</th>
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
                <td>
                    <a href="UpdateEmployeeServlet?empno=<%= emp.getEmpno() %>" class="btn btn-warning btn-sm">Edit</a>
                    <a href="DeleteEmployeeServlet?empno=<%= emp.getEmpno() %>" class="btn btn-danger  btn-sm">Delete</a>
                </td>
            </tr></tbody>
        </table>
    </div>
    <% } %>

    <!-- All employees result -->
    <% if ("all".equals(mode) && employees != null) { %>
    <div class="card">
        <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:20px;">
            <div>
                <div class="card-title">All Employees</div>
                <div class="card-subtitle" style="margin-bottom:0;">
                    Total records: <strong><%= employees.size() %></strong>
                </div>
            </div>
            <a href="empadd.jsp" class="btn btn-success">&#10133; Add New</a>
        </div>

        <% if (employees.isEmpty()) { %>
            <p style="color:#6b7a99; text-align:center; padding:40px 0;">No employees found. Start by adding one.</p>
        <% } else { %>
        <div class="table-wrap">
        <table>
            <thead><tr>
                <th>Emp No.</th><th>Name</th><th>Date of Joining</th><th>Gender</th><th>Basic Salary</th><th>Actions</th>
            </tr></thead>
            <tbody>
            <% for (Employee e : employees) { %>
            <tr>
                <td><strong><%= e.getEmpno() %></strong></td>
                <td><%= e.getEmpName() %></td>
                <td><%= e.getDoj() %></td>
                <td>
                    <span class="badge badge-<%= e.getGender().toLowerCase() %>">
                        <%= e.getGender() %>
                    </span>
                </td>
                <td>&#8377; <%= e.getBsalary() %></td>
                <td>
                    <a href="UpdateEmployeeServlet?empno=<%= e.getEmpno() %>" class="btn btn-warning btn-sm">Edit</a>
                    <a href="DeleteEmployeeServlet?empno=<%= e.getEmpno() %>" class="btn btn-danger  btn-sm">Delete</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        </div>
        <% } %>
    </div>
    <% } %>

</div>
</body>
</html>
