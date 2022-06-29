package com.generationg1.services;

import com.generationg1.models.Usuario;
import com.generationg1.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Logica de negocio, o validaciones del sistema*/

@Service
public class UsuarioService {
    /* llamar al Repository (inyeccion de dependencia)*/
    @Autowired
    UsuarioRepository usuarioRepository;

    public void saveUsuario(Usuario usuario) {

        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        //obtener y retornar la lista de usuarios
        return usuarioRepository.findAll();
    }

}