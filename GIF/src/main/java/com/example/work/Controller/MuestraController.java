package com.example.work.Controller;


import com.example.work.entity.Muestra;
import com.example.work.service.MuestraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("muestras")
public class MuestraController {

    private MuestraService service;

    public MuestraController(MuestraService service) {
        this.service = service;
    }

    @GetMapping
    public Muestra getById(@RequestParam Integer id){
        return service.getMuestraById(id);
    }

    /*
    @GetMapping
    public List<Muestra> getAll(){
        return service.getAll();
    }
*/
}
