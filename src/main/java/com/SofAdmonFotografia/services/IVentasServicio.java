package com.SofAdmonFotografia.services;

import com.SofAdmonFotografia.model.Evento;
import com.SofAdmonFotografia.model.Producto;
import com.SofAdmonFotografia.model.Ventas;
import jakarta.servlet.http.PushBuilder;

import java.math.BigDecimal;
import java.util.List;

public interface IVentasServicio {

    List<Ventas> listarVentas();

    public void SP_RegistroVenta(
            String datos_cliente,
            String detalle_producto,
            String especificaciones,
            String telefono,
            BigDecimal valor_venta,
            BigDecimal valor_abonado,
            BigDecimal valor_resta,
            String estadoDeuda,
            String transferencia
    );
}
