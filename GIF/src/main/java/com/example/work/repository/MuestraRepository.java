package com.example.work.repository;

import com.example.work.entity.Muestra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Integer> {


    List<Muestra> findAllByCultivo(String cultivo);
}
