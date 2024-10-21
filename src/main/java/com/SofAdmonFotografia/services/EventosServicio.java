package com.SofAdmonFotografia.services;

import com.SofAdmonFotografia.model.Evento;
import com.SofAdmonFotografia.repository.EventosRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventosServicio implements IEventosServicio {

    @Autowired
    private EventosRepository eventosRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Evento> listarEventos() {
        return eventosRepository.findAll();
    }

    @Override
    public void SP_RegistrarEvento(String nombreCliente, String telefono, LocalDate fechaEvento, String codigo,
                                     String detalleEvento, String direccion, String estadoDeuda) {
        try {
            // Crear el StoredProcedureQuery
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("SP_RegistrarEvento");

            // Registrar los parámetros de entrada
            query.registerStoredProcedureParameter("nombre_cliente", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("telefono", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("fecha_evento", java.sql.Timestamp.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("codigo", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("detalle_evento", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("direccion", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("estado_deuda", String.class, ParameterMode.IN);

            // Registrar los parámetros de salida
            query.registerStoredProcedureParameter("id_evento", Integer.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("mensaje", String.class, ParameterMode.OUT);

            // Asignar valores a los parámetros de entrada
            query.setParameter("nombre_cliente", nombreCliente);
            query.setParameter("telefono", telefono);
            query.setParameter("fecha_evento", java.sql.Timestamp.valueOf(fechaEvento.atStartOfDay())); // Convirtiendo LocalDate a Timestamp
            query.setParameter("codigo", codigo);
            query.setParameter("detalle_evento", detalleEvento);
            query.setParameter("direccion", direccion);
            query.setParameter("estado_deuda", estadoDeuda);

            // Ejecutar el procedimiento almacenado
            query.execute();

            // Obtener los valores de los parámetros de salida
            Integer idEvento = (Integer) query.getOutputParameterValue("id_evento");
            String mensaje = (String) query.getOutputParameterValue("mensaje");

            // Manejar el mensaje de respuesta y el id_evento
            if (idEvento == -1) {
                throw new RuntimeException(mensaje); // Lanza excepción si el evento ya existe
            }

            System.out.println("ID del evento registrado: " + idEvento);
            System.out.println("Mensaje: " + mensaje);

        } catch (Exception e) {
            throw new RuntimeException("Error al registrar el evento: " + e.getMessage());
        }
    }

    @Override
    public void eliminarEventos(Evento evento) {
        eventosRepository.delete(evento);
    }
}
