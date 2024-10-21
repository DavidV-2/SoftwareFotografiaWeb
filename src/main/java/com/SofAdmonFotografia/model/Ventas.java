package com.SofAdmonFotografia.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "venta")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(name = "datosCliente", nullable = false, length = 20)
    private String datosCliente;

    @Column(name = "detalleProducto", nullable = false, length = 20)
    private String detalleProducto;

    @Column(name = "especificaciones", nullable = false)
    private String especificaciones;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "valorVenta", nullable = false)
    private BigDecimal valorVenta;

    @Column(name = "valor_abonado", nullable = false)
    private BigDecimal valorAbono;

    @Column(name = "valorResta", nullable = false)
    private BigDecimal valorResta;

    @Column(name = "estadoDeuda", nullable = false, length = 20)
    private String estadoDeuda;  // "Abono", "No Abono", "Cancelo"

    @Column(name = "transferencia",nullable = false, length = 3)
    private String transferencia;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(String datosCliente) {
        this.datosCliente = datosCliente;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(BigDecimal valorVenta) {
        this.valorVenta = valorVenta;
    }

    public BigDecimal getValorAbono() {
        return valorAbono;
    }

    public void setValorAbono(BigDecimal valorAbono) {
        this.valorAbono = valorAbono;
    }

    public BigDecimal getValorResta() {
        return valorResta;
    }

    public void setValorResta(BigDecimal valorResta) {
        this.valorResta = valorResta;
    }

    public String getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(String estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    public String getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(String transferencia) {
        this.transferencia = transferencia;
    }
}
