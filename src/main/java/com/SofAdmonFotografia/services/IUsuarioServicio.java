package com.SofAdmonFotografia.services;

import com.SofAdmonFotografia.model.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioporRol(Integer idRol);
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
}
