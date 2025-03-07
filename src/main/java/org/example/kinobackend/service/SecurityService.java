package org.example.kinobackend.service;

import org.example.kinobackend.model.UserRole;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean hasRole(String role, UserRole requiredRole) {
        try {
            UserRole userRole = UserRole.valueOf(role.toUpperCase());
            return userRole == requiredRole;
        } catch (IllegalArgumentException e) { //for avoiding crashing if unexpected role is passed
            return false;
        }
    }
}
