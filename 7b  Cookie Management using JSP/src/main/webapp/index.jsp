<!DOCTYPE html>
<html>
<head>
    <title>Cookie Management</title>
</head>
<body>

<h2>Cookie Management System</h2>

<form action="addCookie.jsp" method="post">

    Name: <input type="text" name="name" required><br><br>

    Domain: <input type="text" name="domain" required><br><br>

    Max Expiry Age (seconds): 
    <input type="number" name="maxage" required><br><br>

    <input type="submit" value="Add Cookie">

</form>

<br>

<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>