<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Employee, java.util.List" %>
<%
    List<Employee> results  = (List<Employee>) request.getAttribute("reportResults");
    String reportTitle      = (String) request.getAttribute("reportTitle");
    String reportDesc       = (String) request.getAttribute("reportDesc");
    String reportType       = (String) request.getAttribute("reportType");
    if (reportTitle == null) reportTitle = "Report Results";
    if (reportDesc  == null) reportDesc  = "";
    if (results == null)     results = new java.util.ArrayList<>();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><%= reportTitle %> | EMS</title>
    <link rel="stylesheet" href="css/style.css"/>
    <style>
        @media print {
            .navbar, .no-print { display:none !important; }
            .card { box-shadow:none; border:1px solid #ccc; }
        }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="index.jsp" class="brand">&#128188; EMS Portal</a>
    <nav>
        <a href="empadd.jsp">Add</a>
        <a href="empupdate.jsp">Update</a>
        <a href="empdelete.jsp">Delete</a>
        <a href="DisplayEmployeeServlet">Display All</a>
        <a href="report_form.jsp" class="active">Reports</a>
    </nav>
</nav>

<div class="page-wrapper">
    <div class="card">

        <!-- Header -->
        <div style="display:flex; justify-content:space-between; align-items:flex-start; flex-wrap:wrap; gap:12px; margin-bottom:24px;">
            <div>
                <div class="card-title">&#128202; <%= reportTitle %></div>
                <div class="card-subtitle" style="margin-bottom:0;"><%= reportDesc %></div>
            </div>
            <div style="display:flex; gap:10px;" class="no-print">
                <button onclick="window.print()" class="btn btn-secondary btn-sm">&#128424;&#65039; Print</button>
                <a href="report_form.jsp" class="btn btn-secondary btn-sm">&#8592; New Report</a>
                <a href="index.jsp"       class="btn btn-secondary btn-sm">&#8962; Home</a>
            </div>
        </div>

        <!-- Summary stat -->
        <div class="stat-row no-print" style="margin-bottom:20px;">
            <div class="stat-box">
                <div class="stat-val"><%= results.size() %></div>
                <div class="stat-lbl">Records Found</div>
            </div>
            <% if (!results.isEmpty()) {
                java.math.BigDecimal total = java.math.BigDecimal.ZERO;
                java.math.BigDecimal max   = results.get(0).getBsalary();
                java.math.BigDecimal min   = results.get(0).getBsalary();
                for (Employee e : results) {
                    total = total.add(e.getBsalary());
                    if (e.getBsalary().compareTo(max) > 0) max = e.getBsalary();
                    if (e.getBsalary().compareTo(min) < 0) min = e.getBsalary();
                }
                java.math.BigDecimal avg = total.divide(
                    java.math.BigDecimal.valueOf(results.size()), 2, java.math.RoundingMode.HALF_UP);
            %>
            <div class="stat-box">
                <div class="stat-val" style="font-size:20px;">&#8377;<%= avg %></div>
                <div class="stat-lbl">Avg Salary</div>
            </div>
            <div class="stat-box">
                <div class="stat-val" style="font-size:20px;">&#8377;<%= max %></div>
                <div class="stat-lbl">Highest Salary</div>
            </div>
            <div class="stat-box">
                <div class="stat-val" style="font-size:20px;">&#8377;<%= min %></div>
                <div class="stat-lbl">Lowest Salary</div>
            </div>
            <% } %>
        </div>

        <!-- Results table -->
        <% if (results.isEmpty()) { %>
            <div style="text-align:center; padding:48px 0; color:#6b7a99;">
                <div style="font-size:40px; margin-bottom:12px;">&#128269;</div>
                <p style="font-size:15px;">No employees match the selected criteria.</p>
                <a href="report_form.jsp" class="btn btn-primary" style="margin-top:16px; display:inline-block;">Try Different Criteria</a>
            </div>
        <% } else { %>
        <div class="table-wrap">
        <table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Emp No.</th>
                    <th>Employee Name</th>
                    <th>Date of Joining</th>
                    <th>Gender</th>
                    <th>Basic Salary (&#8377;)</th>
                    <% if ("2".equals(reportType)) { %><th>Years of Service</th><% } %>
                </tr>
            </thead>
            <tbody>
            <% int sno = 1; for (Employee e : results) {
                // Calculate years of service
                long years = 0;
                if (e.getDoj() != null) {
                    java.time.LocalDate doj  = e.getDoj().toLocalDate();
                    java.time.LocalDate now  = java.time.LocalDate.now();
                    years = java.time.temporal.ChronoUnit.YEARS.between(doj, now);
                }
            %>
            <tr>
                <td style="color:#6b7a99;"><%= sno++ %></td>
                <td><strong><%= e.getEmpno() %></strong></td>
                <td><%= e.getEmpName() %></td>
                <td><%= e.getDoj() %></td>
                <td>
                    <span class="badge badge-<%= e.getGender().toLowerCase() %>">
                        <%= e.getGender() %>
                    </span>
                </td>
                <td><strong>&#8377; <%= e.getBsalary() %></strong></td>
                <% if ("2".equals(reportType)) { %>
                <td><%= years %> yrs</td>
                <% } %>
            </tr>
            <% } %>
            </tbody>
        </table>
        </div>

        <!-- Print footer -->
        <div style="margin-top:16px; font-size:12px; color:#9aa3bf; text-align:right;">
            Report generated on: <%= new java.util.Date() %>
        </div>
        <% } %>

    </div>
</div>

</body>
</html>
