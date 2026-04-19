package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        // Check existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", username);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry (for demo: 30 seconds)
        int expiryTime = 30;

        nameCookie.setMaxAge(expiryTime);
        visitCookie.setMaxAge(expiryTime);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome back " + username + "!</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");

        // Display cookies + set values
        out.println("<h3>List of Cookies with Values:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Cookie Name: " + c.getName() + "<br>");
                out.println("Value: " + c.getValue() + "<br>");
                out.println("Max Age (seconds): " + c.getMaxAge() + "<br>");
                out.println("-------------------------<br>");
            }
        }

        out.println("<p><b>Note:</b> Cookies expire in " + expiryTime + " seconds.</p>");

        out.println("</body></html>");
    }
}