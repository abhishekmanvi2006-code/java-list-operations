package cokie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        Cookie[] cookies = request.getCookies();
        int visitCount = 0;
        boolean found = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            visitCount = 1;
        }

        // Create cookie
        Cookie userCookie = new Cookie(name, String.valueOf(visitCount));

        // Expiry time (30 seconds demonstration)
        userCookie.setMaxAge(30);

        response.addCookie(userCookie);

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");
        out.println("<p><b>Cookie will expire in 30 seconds.</b></p>");
        out.println("</body></html>");
    }
}