package com.SofAdmonFotografia.services;

import com.SofAdmonFotografia.model.Usuario;
import com.SofAdmonFotografia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioporRol(Integer idRol) {
        Usuario usuario= usuarioRepository.findById(idRol).orElse(null);
        return usuario;
    }
    @Override
    @Transactional
    public void guardarUsuario(Usuario usuario) {

        usuarioRepository.save(usuario);
    }
    @Override
    @Transactional
    public void eliminarUsuario(Usuario usuario) {

        usuarioRepository.delete(usuario);
    }
}
