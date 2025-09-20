package com.example.tuan04.controller;

import com.example.tuan04.model.User;
import com.example.tuan04.service.RegistrationServiceImpl;
import com.example.tuan04.service.interf.RegistrationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registrationController2", urlPatterns = {"/bai1"})
public class Bai1 extends HttpServlet {
    private RegistrationService registrationService;

    @Override
    public void init() throws ServletException {
        this.registrationService = new RegistrationServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("bai1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = registrationService.registerUser(request);

        request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("result-form2.jsp");
        rd.forward(request, response);
    }
}
