package org.example.kinobackend.controller;

import org.example.kinobackend.model.UserRole;
import org.example.kinobackend.service.AdminService;
import org.example.kinobackend.service.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;
    private final SecurityService securityService;

    public AdminController(AdminService adminService, SecurityService securityService) {
        this.adminService = adminService;
        this.securityService = securityService;
    }

    @GetMapping("/movie/{id}/sales-revenue")                         //get the role from the header of the request
    public ResponseEntity<?> getSalesAndRevenue(@RequestHeader(value = "Role") String role,
                                                     @PathVariable int id) {
        if (securityService.hasRole(role, UserRole.ADMIN)) {
            return ResponseEntity.ok(adminService.getSalesAndRevenue(id));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access for role " + role + " denied.");
        }
    }
}
