package com.SofAdmonFotografia.services;

import com.SofAdmonFotografia.model.Producto;

import java.util.List;

public interface IProductoServicio {

    List<Producto> SP_BuscarProductos(int referencia, String codigo,String descripcion);
    List<Producto> listarProductos();
    void guardarProducto(Producto Producto);
    void eliminarProducto(Producto Producto);
}
