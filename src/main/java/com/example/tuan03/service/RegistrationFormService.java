package com.example.tuan03.service;

import com.example.tuan03.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "registerServlet", urlPatterns = {"/registration-form"})

public class RegistrationFormService {
    public Student registerStudent(HttpServletRequest request) {
        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("txtEmail");
        String mobile = request.getParameter("txtMobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("txtCity");
        String pinCode = request.getParameter("txtPinCode");
        String state = request.getParameter("txtState");
        String country = request.getParameter("txtCountry");

        String[] hobbiesArr = request.getParameterValues("chkHobbies");
        String hobbies = (hobbiesArr != null) ? String.join(", ", hobbiesArr) : "";

        String course = request.getParameter("rdCourse");
        String birthDate = day + "/" + month + "/" + year;

        // tạo Student
        Student sv = new Student();
        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setMobile(mobile);
        sv.setBirthday(birthDate);
        sv.setAddress(address);
        sv.setCity(city);
        sv.setPinCode(pinCode);
        sv.setState(state);
        sv.setCountry(country);
//        sv.setHobbies(hobbies);
//        sv.setCourse(course);

        return sv;
    }
}
