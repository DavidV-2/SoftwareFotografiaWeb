package com.SofAdmonFotografia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "usuario" )
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private Integer idUsuario;
        @Column(name = "documento")
        private String documento;
        @Column(name = "nombre_completo")
        private String nombreCompleto;
        @Column(name = "correo")
        private String correo;
        @Column(name = "clave")
        private String clave;
        @Column(name = "id_rol")
        private String idRol;
        @Column(name = "estado")
        private String estado;
}