package com.solocubos.usuarioeps.app.usuarioeps.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "eps")
public class Eps implements Serializable{

    @Id
    @Column(name = "nit")
    private Integer Nit;

    @Column(name = "razon_social", length = 20)
    private String RazonSocial;

    @Column(name = "direccion", length = 50)
    private String Direccion;

    @Column(name = "telefono", length = 10)
    private String Telefono;

}
