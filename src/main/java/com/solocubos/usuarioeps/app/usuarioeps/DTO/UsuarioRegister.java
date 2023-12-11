package com.solocubos.usuarioeps.app.usuarioeps.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRegister {

    private Integer cedula;
    private String nombre;
    private String username;
    private String password;
    private String direccion;
}
