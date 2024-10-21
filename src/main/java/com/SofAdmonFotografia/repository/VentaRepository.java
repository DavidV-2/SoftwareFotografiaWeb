package com.SofAdmonFotografia.repository;

import com.SofAdmonFotografia.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VentaRepository  extends JpaRepository<Ventas, Integer> {


    @Query(value = "{call SP_RegistroVenta(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}", nativeQuery = true)
    void SP_RegistroVenta(
            String detalle_producto,
            String datos_cliente,
            String telefono,
            String especificaciones,
            BigDecimal valor_venta,
            BigDecimal valor_abonado,
            BigDecimal valor_resta,
            String estadoDeuda,
            String transferencia);
}
