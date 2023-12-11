package com.solocubos.usuarioeps.app.usuarioeps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solocubos.usuarioeps.app.usuarioeps.entities.Eps;
import com.solocubos.usuarioeps.app.usuarioeps.service.EpsService;

@RestController
@RequestMapping(path = "/api/v1/eps")
public class EpsController {

    @Autowired
    EpsService servicio;

    @GetMapping("/status")
    public String epsStatus(){
        return "Todo bien perraaaaa";
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOneEps(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Eps eps){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(eps));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Eps eps){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, eps));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

}
