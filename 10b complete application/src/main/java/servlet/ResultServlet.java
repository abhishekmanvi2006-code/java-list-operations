package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        try {
            int s1 = Integer.parseInt(request.getParameter("sub1"));
            int s2 = Integer.parseInt(request.getParameter("sub2"));
            int s3 = Integer.parseInt(request.getParameter("sub3"));
            int s4 = Integer.parseInt(request.getParameter("sub4"));
            int s5 = Integer.parseInt(request.getParameter("sub5"));

            // Server-side validation
            if (rollno.isEmpty() || name.isEmpty()) {
                response.getWriter().println("Error: All fields required!");
                return;
            }

            if (s1<0||s1>100 || s2<0||s2>100 || s3<0||s3>100 ||
                s4<0||s4>100 || s5<0||s5>100) {
                response.getWriter().println("Error: Marks must be 0–100!");
                return;
            }

            // Result logic
            int total = s1 + s2 + s3 + s4 + s5;
            double avg = total / 5.0;

            String result = (s1>40 && s2>40 && s3>40 && s4>40 && s5>40) ? "PASS" : "FAIL";

            // Send data to JSP
            request.setAttribute("rollno", rollno);
            request.setAttribute("name", name);
            request.setAttribute("s1", s1);
            request.setAttribute("s2", s2);
            request.setAttribute("s3", s3);
            request.setAttribute("s4", s4);
            request.setAttribute("s5", s5);
            request.setAttribute("avg", avg);
            request.setAttribute("result", result);

            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            response.getWriter().println("Invalid Input!");
        }
    }
}