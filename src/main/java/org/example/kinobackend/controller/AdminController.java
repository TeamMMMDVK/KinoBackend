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

//    @GetMapping("/movie/{id}/sale")                         //get the role from the header of the request
//    public ResponseEntity<?> getTotalNumberOfTickets(@RequestHeader(value = "Role") String role,
//                                                     @PathVariable int id) {
//        if (securityService.hasRole(role, UserRole.ADMIN)) {
//            return ResponseEntity.ok(adminService.getTotalNumberOfTickets(id));
//        } else {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access for role " + role + " denied.");
//        }
//    }
//
//    @GetMapping("/movie/{id}/revenue")                         //get the role from the header of the request
//    public ResponseEntity<?> getTotalRevenueOfMovie(@RequestHeader(value = "Role") String role,
//                                                     @PathVariable int id) {
//        if (securityService.hasRole(role, UserRole.ADMIN)) {
//            return ResponseEntity.ok(adminService.getTotalRevenueOfMovie(id));
//        } else {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access for role " + role + " denied.");
//        }
//    }
}
