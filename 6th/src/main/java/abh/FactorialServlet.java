package abh;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fact")   // URL mapping without web.xml
public class FactorialServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));
        long fact = 1;

        for(int i = 1; i <= num; i++) {
            fact = fact * i;
        }

        out.println("<html><body>");
        out.println("<h2>Factorial of " + num + " is: " + fact + "</h2>");
        out.println("</body></html>");
    }
}