package com.SofAdmonFotografia.services;


import com.SofAdmonFotografia.model.Ventas;
import com.SofAdmonFotografia.repository.VentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VentasServicio implements IVentasServicio {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Ventas> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void SP_RegistroVenta(String datos_cliente,String detalle_producto, String especificaciones, String telefono, 
                                 BigDecimal valor_venta, BigDecimal valor_abonado, BigDecimal valor_resta,
                                 String estadoDeuda, String transferencia) {
        try {
            // Crear el StoredProcedureQuery
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_RegistroVenta");

            // Registrar los parámetros de entrada
            query.registerStoredProcedureParameter("datos_cliente", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("detalle_producto", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("especificaciones", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("telefono", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("valor_venta", BigDecimal.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("valor_abonado", BigDecimal.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("valor_resta", BigDecimal.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("estado_deuda", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("transferencia", String.class, ParameterMode.IN);

            // Registrar los parámetros de salida
            query.registerStoredProcedureParameter("id_venta", Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("mensaje", String.class, ParameterMode.OUT);

            // Asignar valores a los parámetros de entrada
            query.setParameter("datos_cliente", datos_cliente);
            query.setParameter("detalle_producto", detalle_producto);
            query.setParameter("especificaciones", especificaciones);
            query.setParameter("telefono", telefono);
            query.setParameter("valor_venta", valor_venta); // Convirtiendo LocalDate a Timestamp
            query.setParameter("valor_abonado", valor_abonado);
            query.setParameter("valor_resta", valor_resta);
            query.setParameter("estado_deuda", estadoDeuda);
            query.setParameter("transferencia", estadoDeuda);

            // Ejecutar el procedimiento almacenado
            query.execute();

            // Obtener los valores de los parámetros de salida
            Integer id_venta = (Integer) query.getOutputParameterValue("id_venta");
            String mensaje = (String) query.getOutputParameterValue("mensaje");

            // Manejar el mensaje de respuesta y el id_evento
            if (id_venta == -1) {
                throw new RuntimeException(mensaje); // Lanza excepción si el evento ya existe
            }

            System.out.println("ID de la venta registrada: " + id_venta);
            System.out.println("Mensaje: " + mensaje);

        } catch (Exception e) {
            throw new RuntimeException("Error al registrar el evento: " + e.getMessage());
        }
    }
}
