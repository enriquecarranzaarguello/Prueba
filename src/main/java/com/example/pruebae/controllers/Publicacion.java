package com.example.pruebae.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1")
@Controller
public class Publicacion {
    @Autowired
    PublicacionRepository publicacionRepository;



    @GetMapping(value = "/public")
    public ResponseEntity<Object> publicacion() {
        return ResponseEntity.ok().body(publicacionRepository.findAll());
    }
    
    @PostMapping(value = "/public")
    public ResponseEntity<Object> insertarPublicacion(@RequestBody PublicacionEntity nuevoPublicacion) {

        PublicacionEntity publicacionGuardado = publicacionRepository.save(nuevoPublicacion);
        return ResponseEntity.ok().body("Registro Exitoso");
    }


}
