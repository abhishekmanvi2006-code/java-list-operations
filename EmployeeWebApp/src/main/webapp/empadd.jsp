<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
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
    <title>Add Employee | EMS</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<nav class="navbar">
    <a href="index.jsp" class="brand">&#128188; EMS Portal</a>
    <nav>
        <a href="empadd.jsp" class="active">Add</a>
        <a href="empupdate.jsp">Update</a>
        <a href="empdelete.jsp">Delete</a>
        <a href="DisplayEmployeeServlet">Display All</a>
        <a href="report_form.jsp">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">
    <div class="card">
        <div class="card-title">&#10133; Add New Employee</div>
        <div class="card-subtitle">Fill in all fields to register a new employee.</div>

        <% if (successMsg != null) { %>
            <div class="alert alert-success">&#10003; <%= successMsg %></div>
        <% } %>
        <% if (errorMsg != null) { %>
            <div class="alert alert-danger">&#9888; <%= errorMsg %></div>
        <% } %>

        <form action="AddEmployeeServlet" method="post">

            <div class="form-group">
                <label for="empno">Employee No. (Primary Key) *</label>
                <input type="number"
                       id="empno"
                       name="empno"
                       class="form-control"
                       placeholder="e.g. 1006"
                       required/>
            </div>

            <div class="form-group">
                <label for="empName">Employee Name *</label>
                <input type="text"
                       id="empName"
                       name="empName"
                       class="form-control"
                       placeholder="Full name"
                       required
                       maxlength="100"/>
            </div>

            <div class="form-group">
                <label for="doj">Date of Joining *</label>
                <input type="date"
                       id="doj"
                       name="doj"
                       class="form-control"
                       required/>
            </div>

            <div class="form-group">
                <label for="gender">Gender *</label>
                <select id="gender"
                        name="gender"
                        class="form-control"
                        required>
                    <option value="" disabled selected>-- Select --</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <div class="form-group">
                <label for="bsalary">Basic Salary *</label>
                <input type="number"
                       id="bsalary"
                       name="bsalary"
                       class="form-control"
                       placeholder="e.g. 45000.00"
                       required
                       min="0"
                       step="0.01"/>
            </div>

            <div style="display:flex; gap:12px; margin-top:16px;">
                <button type="submit" class="btn btn-success">
                    &#10003; Save Employee
                </button>
                <button type="reset" class="btn btn-secondary">
                    Reset
                </button>
                <a href="index.jsp" class="btn btn-secondary">
                    &#8592; Back
                </a>
            </div>

        </form>
    </div>
</div>

</body>
</html>