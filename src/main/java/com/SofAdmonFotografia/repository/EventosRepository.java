package com.SofAdmonFotografia.repository;

import com.SofAdmonFotografia.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventosRepository extends JpaRepository<Evento, Integer> {

    @Query(value = "{call SP_RegistrarEvento(?, ?, ?, ?, ?, ?, ?)}", nativeQuery = true)
    void SP_RegistrarEvento(
            @Param("nombre_cliente") String nombreCliente,
            @Param("telefono") String telefono,
            @Param("fecha_evento") LocalDate fechaEvento,
            @Param("codigo") String codigo,
            @Param("detalle_evento") String detalleEvento,
            @Param("direccion") String direccion,
            @Param("estado_deuda") String estadoDeuda);
}