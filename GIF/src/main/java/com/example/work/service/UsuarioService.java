package com.example.work.service;


import com.example.work.entity.Usuario;
import com.example.work.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String doLogin(String nif, String password ){
        Optional<Usuario> usuarioOptional = repository.getByNif(nif);

        if (usuarioOptional.isPresent() && usuarioOptional.get().getPassword().equals(password)){
            return usuarioOptional.get().getRolname().getRolName();
        }
        return null;
    }


}
