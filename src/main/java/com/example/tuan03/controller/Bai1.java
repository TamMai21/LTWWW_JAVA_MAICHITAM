package com.example.tuan03.controller;

import com.example.tuan03.model.Student;
import com.example.tuan03.service.RegistrationFormService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.IOException;

@WebServlet(name = "registrationController1", urlPatterns = {"/bai1"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bai1 extends HttpServlet {
    RegistrationFormService registrationService;
    @Override
    public void init() throws ServletException {
        this.registrationService = new RegistrationFormService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("bai1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // gọi service để lấy Student từ form
        Student sv = registrationService.registerStudent(request);

        // set student vào request
        request.setAttribute("student", sv);

        // forward sang view
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
