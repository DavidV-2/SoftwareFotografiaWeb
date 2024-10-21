package com.SofAdmonFotografia.services;


import com.SofAdmonFotografia.model.Evento;

import java.time.LocalDate;
import java.util.List;

public interface IEventosServicio {

    List<Evento> listarEventos();

    void SP_RegistrarEvento(
            String nombreCliente,
            String telefono,
            LocalDate fechaEvento,
            String codigo,
            String detalleEvento,
            String direccion,
            String estadoDeuda
    );
    void eliminarEventos(Evento Eventos);
}
