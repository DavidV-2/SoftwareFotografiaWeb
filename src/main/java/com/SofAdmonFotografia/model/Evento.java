package com.SofAdmonFotografia.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column(name = "nombre_cliente", nullable = false, length = 20)
    private String nombreCliente;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDate fechaEvento;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "detalle_evento", nullable = false, length = 100)
    private String detalleEvento;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "estado_deuda", nullable = false, length = 20)
    private String estadoDeuda;

    // Getters y Setters
    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalleEvento() {
        return detalleEvento;
    }

    public void setDetalleEvento(String detalleEvento) {
        this.detalleEvento = detalleEvento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(String estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }
}
