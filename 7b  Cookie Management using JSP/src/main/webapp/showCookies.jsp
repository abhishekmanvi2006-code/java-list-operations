<%@ page import="java.net.URLDecoder" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<body>

<h2>Cookies Data:</h2>

<%
    Cookie[] cookies = request.getCookies();

    if(cookies != null){
        for(Cookie c : cookies){
            if(c.getName().equals("username")){
                String value = URLDecoder.decode(c.getValue(), "UTF-8");
%>
                <p><b>Username:</b> <%= value %></p>
<%
            }
        }
    } else {
%>
        <p>No cookies found</p>
<%
    }
%>

</body>
</html>