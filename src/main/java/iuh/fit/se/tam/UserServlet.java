package iuh.fit.se.tam;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", urlPatterns = {"/user"}, initParams = {
        @WebInitParam(name = "initparam", value = "TAM")
})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        User user = new User().builder()
                .name("TAM")
                .age(20)
                .address("HCM")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        var stringValue = objectMapper.writeValueAsString(user);

        writer.println("context-param: " + this.getServletContext().getInitParameter("initparam"));
        writer.println("init-param: " + this.getServletContext().getInitParameter("contextparam"));
        writer.println("user string value: " + stringValue);


    }
}
