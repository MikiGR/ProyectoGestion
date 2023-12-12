package com.example.work.repository;

import com.example.work.entity.Solucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SolucionRepository extends JpaRepository<Solucion, Integer> {


}
