<%@ page language="java" %>
<%@ page session="true" %>

<%
    // Set session expiry time (1 minute = 60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");
%>

<html>
<head>
    <title>Session Output</title>
</head>
<body>

<%
    if (user != null) {
%>

    <h2>Hello <%= user %> !</h2>
    <p><b>Session will expire in 1 minute of inactivity.</b></p>

<%
    } else {
%>

    <h2>Session Expired!</h2>
    <p>Please enter your name again.</p>

    <a href="index.html">Go Back</a>

<%
    }
%>

</body>
</html>