package com.example.tuan04.service.interf;

import com.example.tuan04.model.User;
import jakarta.servlet.http.HttpServletRequest;

public interface RegistrationService {
    User registerUser(HttpServletRequest request);
}
