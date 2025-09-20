package com.example.tuan04.service;

import com.example.tuan04.model.User;
import jakarta.servlet.http.HttpServletRequest;

public class RegistrationServiceImpl implements com.example.tuan04.service.interf.RegistrationService {
    @Override
    public User registerUser(HttpServletRequest request) {
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String reEmail = request.getParameter("reEmail");
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String gender = request.getParameter("gender");

        String birthday = day + "/" + month + "/" + year;

        return new User(fname, lname, email, reEmail, password, birthday, gender);
    }
}
