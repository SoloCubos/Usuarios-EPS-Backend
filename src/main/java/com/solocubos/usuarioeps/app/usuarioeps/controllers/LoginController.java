package com.solocubos.usuarioeps.app.usuarioeps.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @GetMapping
    public String status(){
        return "Nada por aqui";
    }
}
