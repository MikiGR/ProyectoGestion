package com.example.work.repository;

import com.example.work.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> getByNif(String nif);
}
