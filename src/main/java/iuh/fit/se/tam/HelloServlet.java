package iuh.fit.se.tam;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1> Param trong Servlet " + this.getServletConfig().getInitParameter("username") + "</h1>");
        out.println("<h1> Param trong App " + this.getServletContext().getInitParameter("appName") + "</h1>");
        out.println("</body></html>");


    }

    public void destroy() {
    }
}