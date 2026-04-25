<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Reports Menu | EMS</title>
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
        <a href="reports.jsp" class="active">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">
    <div class="card">
        <div class="card-title">&#128202; Reports</div>
        <div class="card-subtitle">Select the type of report you want to generate.</div>

        <div class="report-grid">

            <a href="ReportCriteriaServlet?type=1" class="report-card">
                <div class="rc-icon">&#128272;</div>
                <div class="rc-title">By Name Letter</div>
                <div class="rc-desc">Employees whose names begin with a specific letter (e.g. all "A" names)</div>
            </a>

            <a href="ReportCriteriaServlet?type=2" class="report-card" style="border-top-color:#22c55e;">
                <div class="rc-icon">&#128197;</div>
                <div class="rc-title">By Years of Service</div>
                <div class="rc-desc">Employees who have served N or more years since their Date of Joining</div>
            </a>

            <a href="ReportCriteriaServlet?type=3" class="report-card" style="border-top-color:#f59e0b;">
                <div class="rc-icon">&#128176;</div>
                <div class="rc-title">By Salary Threshold</div>
                <div class="rc-desc">Employees whose Basic Salary exceeds a specified amount</div>
            </a>

        </div>

        <div style="margin-top:28px;">
            <a href="index.jsp" class="btn btn-secondary">&#8592; Back to Home</a>
        </div>
    </div>
</div>
</body>
</html>
