package iuh.fit.se.tam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        writer.println("Register Form Data DO POST");

        writer.println("init-param: " + req.getServletContext().getInitParameter("nameinit"));
        writer.println("context-param: " + req.getServletContext().getContext("contextparam"));


        writer.println("first name: " + req.getParameter("first_name"));
        writer.println("last name: " + req.getParameter("last_name"));
        writer.println("username: " + req.getParameter("username"));
        writer.println("email: " + req.getParameter("email"));
        writer.println("password: " + req.getParameter("password"));
        writer.println("facebook: " + req.getParameter("facebook"));
        writer.println("bio: " + req.getParameter("bio"));

        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        writer.println("Register Form Data DO GET");

        writer.println("first name: " + req.getParameter("first_name"));
        writer.println("last name: " + req.getParameter("last_name"));
        writer.println("username: " + req.getParameter("username"));
        writer.println("email: " + req.getParameter("email"));
        writer.println("password: " + req.getParameter("password"));
        writer.println("facebook: " + req.getParameter("facebook"));
        writer.println("bio: " + req.getParameter("bio"));

        writer.close();
    }
}
