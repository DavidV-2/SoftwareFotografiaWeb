package com.SofAdmonFotografia.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_categoria")
    private String id_categoria;
    @Column(name = "stock")
    private String stock;
    @Column(name = "precio_venta")
    private String precio_venta;
}
