<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String preSelected = request.getParameter("reportType");
    if (preSelected == null) preSelected = "";
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
    <title>Reports | EMS</title>
    <link rel="stylesheet" href="css/style.css"/>
    <style>
        .report-option { cursor:pointer; }
        .report-option input[type=radio] { display:none; }
        .report-option .rc-card {
            border: 2px solid #e0e4f0; border-radius:12px;
            padding:20px; transition: border-color .2s, background .2s; background:#f8f9fc;
        }
        .report-option input[type=radio]:checked + .rc-card {
            border-color:#4f6af0; background:#eef1fe;
        }
        .criteria-panel { display:none; margin-top:20px; }
        .criteria-panel.active { display:block; }
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
        <div class="card-title">&#128202; Generate Report</div>
        <div class="card-subtitle">Choose a report type and enter the required criteria.</div>

        <% if (errorMsg   != null) { %><div class="alert alert-danger">&#9888; <%= errorMsg %></div><% } %>
        <% if (successMsg != null) { %><div class="alert alert-success">&#10003; <%= successMsg %></div><% } %>

        <form action="ReportServlet" method="post" onsubmit="return validateReport()">

            <!-- Report type selection -->
            <div style="display:grid; grid-template-columns:repeat(auto-fit,minmax(180px,1fr)); gap:14px; margin-bottom:24px;">

                <label class="report-option">
                    <input type="radio" name="reportType" value="1"
                           <%= "1".equals(preSelected) ? "checked" : "" %>
                           onchange="showCriteria('1')"/>
                    <div class="rc-card">
                        <div style="font-size:28px; margin-bottom:8px;">&#128272;</div>
                        <div style="font-weight:700; font-size:14px; color:#1a2640; margin-bottom:4px;">By Name Letter</div>
                        <div style="font-size:12px; color:#6b7a99;">Names starting with a specific letter</div>
                    </div>
                </label>

                <label class="report-option">
                    <input type="radio" name="reportType" value="2"
                           <%= "2".equals(preSelected) ? "checked" : "" %>
                           onchange="showCriteria('2')"/>
                    <div class="rc-card">
                        <div style="font-size:28px; margin-bottom:8px;">&#128197;</div>
                        <div style="font-weight:700; font-size:14px; color:#1a2640; margin-bottom:4px;">By Years of Service</div>
                        <div style="font-size:12px; color:#6b7a99;">N or more years since Date of Joining</div>
                    </div>
                </label>

                <label class="report-option">
                    <input type="radio" name="reportType" value="3"
                           <%= "3".equals(preSelected) ? "checked" : "" %>
                           onchange="showCriteria('3')"/>
                    <div class="rc-card">
                        <div style="font-size:28px; margin-bottom:8px;">&#128176;</div>
                        <div style="font-weight:700; font-size:14px; color:#1a2640; margin-bottom:4px;">By Salary Threshold</div>
                        <div style="font-size:12px; color:#6b7a99;">Earning above a specified amount</div>
                    </div>
                </label>

            </div>

            <!-- Criteria panels (shown dynamically) -->
            <div id="criteria-1" class="criteria-panel <%= "1".equals(preSelected) ? "active" : "" %>">
                <div class="form-group">
                    <label for="nameLetter">Starting Letter</label>
                    <input type="text" id="nameLetter" name="nameLetter" class="form-control"
                           placeholder="e.g. A" maxlength="1" style="max-width:140px; text-transform:uppercase;"/>
                </div>
            </div>

            <div id="criteria-2" class="criteria-panel <%= "2".equals(preSelected) ? "active" : "" %>">
                <div class="form-group">
                    <label for="yearsOfService">Minimum Years of Service</label>
                    <input type="number" id="yearsOfService" name="yearsOfService" class="form-control"
                           placeholder="e.g. 5" min="0" max="60" style="max-width:200px;"/>
                </div>
            </div>

            <div id="criteria-3" class="criteria-panel <%= "3".equals(preSelected) ? "active" : "" %>">
                <div class="form-group">
                    <label for="salaryThreshold">Salary Threshold (&#8377;)</label>
                    <input type="number" id="salaryThreshold" name="salaryThreshold" class="form-control"
                           placeholder="e.g. 50000" min="0" step="0.01" style="max-width:240px;"/>
                </div>
            </div>

            <div style="display:flex; gap:12px; margin-top:8px;">
                <button type="submit" class="btn btn-primary">&#128202; Generate Report</button>
                <a href="index.jsp" class="btn btn-secondary">&#8592; Home</a>
            </div>

        </form>
    </div>
</div>

<script>
function showCriteria(type) {
    ['1','2','3'].forEach(t => {
        const el = document.getElementById('criteria-' + t);
        el.classList.toggle('active', t === type);
    });
}

// If a type is pre-selected on load
(function() {
    const pre = '<%= preSelected %>';
    if (pre) showCriteria(pre);

    // Also wire up radio clicks
    document.querySelectorAll('input[name="reportType"]').forEach(radio => {
        radio.addEventListener('change', () => showCriteria(radio.value));
    });
})();

function validateReport() {
    const selected = document.querySelector('input[name="reportType"]:checked');
    if (!selected) { alert('Please select a report type.'); return false; }
    const type = selected.value;
    if (type === '1') {
        const v = document.getElementById('nameLetter').value.trim();
        if (!v) { alert('Please enter a starting letter.'); return false; }
    } else if (type === '2') {
        const v = document.getElementById('yearsOfService').value.trim();
        if (!v) { alert('Please enter number of years.'); return false; }
    } else if (type === '3') {
        const v = document.getElementById('salaryThreshold').value.trim();
        if (!v) { alert('Please enter a salary threshold.'); return false; }
    }
    return true;
}
</script>
</body>
</html>
