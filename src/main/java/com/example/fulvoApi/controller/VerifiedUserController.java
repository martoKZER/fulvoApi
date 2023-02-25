package com.example.fulvoApi.controller;

import com.example.fulvoApi.entity.VerifiedUser;
import com.example.fulvoApi.service.VerifiedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("fulvo/verify")
public class VerifiedUserController {
    public VerifiedUserService userService;

    @Autowired
    public VerifiedUserController(VerifiedUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/verify")
    public String verifyUser(@RequestParam("email") String email) {
        Optional<VerifiedUser> user = userService.findByEmail(email);
        if (user.isPresent()) {
            return "El usuario " + email + " ha sido verificado.";
        } else {
            return "El usuario " + email + " no existe.";
        }
    }
}
