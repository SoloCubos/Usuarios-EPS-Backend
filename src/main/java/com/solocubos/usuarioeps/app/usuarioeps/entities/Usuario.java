package com.solocubos.usuarioeps.app.usuarioeps.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable{

    @Id
    @Column(name = "cedula")
    private Integer cedula;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "fecha_afiliacion")
    private Date fechaAfiliacion;

    @OneToOne
    @JoinColumn(name = "eps_actual")
    private Eps epsActual;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
