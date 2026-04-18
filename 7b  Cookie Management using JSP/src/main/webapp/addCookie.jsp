<%@ page import="java.net.URLEncoder" %>
<%@ page import="javax.servlet.http.Cookie" %>

<%
    String name = request.getParameter("name");
    if(name == null) name = "";

    String encoded = URLEncoder.encode(name, "UTF-8");

    Cookie c = new Cookie("username", encoded);
    c.setPath("/");

    response.addCookie(c);

    // Redirect to showCookies.jsp
    response.sendRedirect("showCookies.jsp");
%>