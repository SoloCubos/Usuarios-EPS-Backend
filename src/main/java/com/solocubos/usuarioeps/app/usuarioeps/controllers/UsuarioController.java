package com.solocubos.usuarioeps.app.usuarioeps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solocubos.usuarioeps.app.usuarioeps.DTO.UsuarioRegister;
import com.solocubos.usuarioeps.app.usuarioeps.entities.Usuario;
import com.solocubos.usuarioeps.app.usuarioeps.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService servicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/status")
    public String usuarioStatus(){
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
    public ResponseEntity<?> getOneUser(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody UsuarioRegister usuarioRegister){
        try {
            Usuario usuario = Usuario.builder()
                                     .cedula(usuarioRegister.getCedula())
                                     .nombre(usuarioRegister.getNombre())
                                     .username(usuarioRegister.getUsername())
                                     .password(passwordEncoder.encode(usuarioRegister.getPassword()))
                                     .direccion(usuarioRegister.getDireccion())
                                     .build();
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error 69, Por favor intente mas tarde: " + e + " .\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuario usuario){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, usuario));
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
