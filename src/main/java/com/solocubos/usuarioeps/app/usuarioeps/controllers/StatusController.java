package com.solocubos.usuarioeps.app.usuarioeps.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/status")
public class StatusController {

    @GetMapping
    public String status() {
        return "ok";
    }


}
