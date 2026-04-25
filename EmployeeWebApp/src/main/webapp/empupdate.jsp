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
    <title>Update Employee | EMS</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<nav class="navbar">
    <a href="index.jsp" class="brand">&#128188; EMS Portal</a>
    <nav>
        <a href="empadd.jsp">Add</a>
        <a href="empupdate.jsp" class="active">Update</a>
        <a href="empdelete.jsp">Delete</a>
        <a href="DisplayEmployeeServlet">Display All</a>
        <a href="report_form.jsp">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">

    <!-- Step 1: Search by Empno -->
    <% if (emp == null) { %>
    <div class="card">
        <div class="card-title">&#9999;&#65039; Update Employee</div>
        <div class="card-subtitle">Enter the Employee No. to load the existing record for editing.</div>

        <% if (successMsg != null) { %><div class="alert alert-success">&#10003; <%= successMsg %></div><% } %>
        <% if (errorMsg   != null) { %><div class="alert alert-danger">&#9888; <%= errorMsg %></div><% } %>

        <form action="UpdateEmployeeServlet" method="get" style="display:flex;gap:12px;align-items:flex-end;">
            <div class="form-group" style="flex:1; margin-bottom:0;">
                <label for="empno">Employee No.</label>
                <input type="number" id="empno" name="empno" class="form-control" placeholder="e.g. 1001" required min="1"/>
            </div>
            <button type="submit" class="btn btn-primary">Search &rarr;</button>
            <a href="index.jsp" class="btn btn-secondary">&#8592; Back</a>
        </form>
    </div>

    <% } else { %>

    <!-- Step 2: Edit form pre-filled with existing data -->
    <div class="card">
        <div class="card-title">&#9999;&#65039; Edit Employee &mdash; #<%= emp.getEmpno() %></div>
        <div class="card-subtitle">Modify the fields below and click Update to save changes.</div>

        <% if (successMsg != null) { %><div class="alert alert-success">&#10003; <%= successMsg %></div><% } %>
        <% if (errorMsg   != null) { %><div class="alert alert-danger">&#9888; <%= errorMsg %></div><% } %>

        <form action="UpdateEmployeeServlet" method="post">
            <input type="hidden" name="empno" value="<%= emp.getEmpno() %>"/>

            <div style="display:grid; grid-template-columns:1fr 1fr; gap:0 24px;">

                <div class="form-group">
                    <label>Employee No.</label>
                    <input type="text" class="form-control" value="<%= emp.getEmpno() %>" disabled/>
                </div>

                <div class="form-group">
                    <label for="empName">Employee Name <span style="color:#ef4444">*</span></label>
                    <input type="text" id="empName" name="empName" class="form-control"
                           value="<%= emp.getEmpName() %>" required maxlength="100"/>
                </div>

                <div class="form-group">
                    <label for="doj">Date of Joining <span style="color:#ef4444">*</span></label>
                    <input type="date" id="doj" name="doj" class="form-control"
                           value="<%= emp.getDoj() %>" required/>
                </div>

                <div class="form-group">
                    <label for="gender">Gender <span style="color:#ef4444">*</span></label>
                    <select id="gender" name="gender" class="form-control" required>
                        <option value="Male"   <%= "Male".equals(emp.getGender())   ? "selected" : "" %>>Male</option>
                        <option value="Female" <%= "Female".equals(emp.getGender()) ? "selected" : "" %>>Female</option>
                        <option value="Other"  <%= "Other".equals(emp.getGender())  ? "selected" : "" %>>Other</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="bsalary">Basic Salary (₹) <span style="color:#ef4444">*</span></label>
                    <input type="number" id="bsalary" name="bsalary" class="form-control"
                           value="<%= emp.getBsalary() %>" required min="0" step="0.01"/>
                </div>

            </div>

            <div style="display:flex; gap:12px; margin-top:8px;">
                <button type="submit" class="btn btn-warning">&#9999;&#65039; Update Record</button>
                <a href="empupdate.jsp" class="btn btn-secondary">&#8592; Search Again</a>
                <a href="index.jsp"     class="btn btn-secondary">&#8962; Home</a>
            </div>
        </form>
    </div>
    <% } %>
</div>
</body>
</html>
