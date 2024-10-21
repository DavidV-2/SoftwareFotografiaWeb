package com.SofAdmonFotografia.services;

import com.SofAdmonFotografia.model.Producto;
import com.SofAdmonFotografia.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> SP_BuscarProductos(int referencia, String codigo, String descripcion) {
        return productoRepository.SP_BuscarProductos(referencia, codigo, descripcion);
    }

    @Override
    @Transactional
    public void guardarProducto(Producto Producto) {

    }

    @Override
    @Transactional
    public void eliminarProducto(Producto Producto) {

    }
}
