package com.SofAdmonFotografia.repository;

import com.SofAdmonFotografia.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {

    @Procedure(procedureName = "SP_BuscarProductos")
    List<Producto> SP_BuscarProductos(@Param("referencia") int referencia,
                                      @Param("codigo") String codigo,
                                      @Param("descripcion") String descripcion);
}
