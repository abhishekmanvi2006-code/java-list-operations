<%@ page import="java.util.*" %>
<html>
<body>

<%
String name = request.getParameter("username");
int time = Integer.parseInt(request.getParameter("time"));

// Create session
session.setAttribute("username", name);

// Set session expiry (convert minutes → seconds)
session.setMaxInactiveInterval(time * 60);
%>

<h2>Hello <%= name %>!</h2>

<p>Session will expire in <b><%= time %> minutes</b>.</p>

<a href="check.jsp">Click here to check session</a>

</body>
</html>