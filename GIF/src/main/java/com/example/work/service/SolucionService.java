package com.example.work.service;


import com.example.work.entity.Solucion;
import com.example.work.repository.SolucionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolucionService {

    private SolucionRepository repository;

    public SolucionService(SolucionRepository repository) {
        this.repository = repository;
    }

    public Solucion getById(Integer id){
        Optional<Solucion> optionalSolucion = repository.findById(id);

        return optionalSolucion.isPresent() ? optionalSolucion.get() : null;
    }

    public List<Solucion> getSoluciones(){
        return repository.findAll();
    }

}
