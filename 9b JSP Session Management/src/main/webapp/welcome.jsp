<%@ page import="java.util.*" %>
<html>
<body>

<%
String name = request.getParameter("username");

// Create session and store name
session.setAttribute("username", name);

// Set session expiry = 1 minute (60 seconds)
session.setMaxInactiveInterval(60);
%>

<h2>Hello <%= name %>!</h2>

<p>Session will expire in <b>1 minute</b>.</p>

<a href="check.jsp">Click here to check session</a>

</body>
</html>