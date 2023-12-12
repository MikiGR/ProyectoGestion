package com.example.work.service;


import com.example.work.entity.Muestra;
import com.example.work.entity.Solucion;
import com.example.work.repository.MuestraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuestraService {

    private MuestraRepository repository;

    public MuestraService(MuestraRepository repository) {
        this.repository = repository;
    }

    public Muestra getMuestraById(Integer id){
        Optional<Muestra> muestraOptional = repository.findById(id);
        if (muestraOptional.isPresent()){
            return muestraOptional.get();
        } else {
            return null;
        }
    }

    public List<Muestra> getMuestras(){
        return repository.findAll();
    }



    public void delete(Muestra muestra){
        repository.delete(muestra);
    }


    public Muestra create(String nifPaciente, String cultivo, Solucion solucion){

        Muestra muestra = new Muestra();
        muestra.setNifPaciente(nifPaciente);
        muestra.setCultivo(cultivo);
        muestra.setSolucion(solucion);

        return repository.save(muestra);
    }

    public List<Muestra> getAll() {
        return repository.findAll();
    }

    public Muestra update(Integer id, String cultivo, Solucion solucion){

        Muestra muestra = getMuestraById(id);
        muestra.setCultivo(cultivo);
        muestra.setSolucion(solucion);
        return repository.save(muestra);

    }


}
