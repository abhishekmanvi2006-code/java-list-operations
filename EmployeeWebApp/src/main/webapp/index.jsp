<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Employee Management System</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<nav class="navbar">
    <a href="index.jsp" class="brand">&#128188; EMS Portal</a>
    <nav>
        <a href="empadd.jsp">Add</a>
        <a href="empupdate.jsp">Update</a>
        <a href="empdelete.jsp">Delete</a>
        <a href="DisplayEmployeeServlet">Display All</a>
        <a href="report_form.jsp">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">

    <div class="card" style="text-align:center; padding:48px 36px;">
        <div style="font-size:52px; margin-bottom:16px;">&#128188;</div>
        <h1 style="font-size:28px; font-weight:800; color:#1a2640; margin-bottom:8px;">
            Employee Management System
        </h1>
        <p style="color:#6b7a99; font-size:15px; margin-bottom:36px;">
            Manage your employee records — add, update, delete, display and run reports.
        </p>

        <!-- Quick action grid -->
        <div style="display:grid; grid-template-columns:repeat(auto-fit,minmax(160px,1fr)); gap:16px; text-align:left;">

            <a href="empadd.jsp" class="report-card" style="border-top-color:#22c55e;">
                <div class="rc-icon">&#10133;</div>
                <div class="rc-title">Add Employee</div>
                <div class="rc-desc">Register a new employee record</div>
            </a>

            <a href="empupdate.jsp" class="report-card" style="border-top-color:#f59e0b;">
                <div class="rc-icon">&#9999;&#65039;</div>
                <div class="rc-title">Update Employee</div>
                <div class="rc-desc">Edit details by Employee No.</div>
            </a>

            <a href="empdelete.jsp" class="report-card" style="border-top-color:#ef4444;">
                <div class="rc-icon">&#128465;&#65039;</div>
                <div class="rc-title">Delete Employee</div>
                <div class="rc-desc">Remove a record by Employee No.</div>
            </a>

            <a href="empdisplay.jsp" class="report-card" style="border-top-color:#4f6af0;">
                <div class="rc-icon">&#128203;</div>
                <div class="rc-title">Display Employee</div>
                <div class="rc-desc">Look up a record by Employee No.</div>
            </a>

            <a href="DisplayEmployeeServlet" class="report-card" style="border-top-color:#8b5cf6;">
                <div class="rc-icon">&#128101;</div>
                <div class="rc-title">All Employees</div>
                <div class="rc-desc">View the full employee directory</div>
            </a>

            <a href="report_form.jsp" class="report-card" style="border-top-color:#0ea5e9;">
                <div class="rc-icon">&#128202;</div>
                <div class="rc-title">Reports</div>
                <div class="rc-desc">Run salary &amp; service reports</div>
            </a>

        </div>
    </div>

</div>
</body>
</html>
