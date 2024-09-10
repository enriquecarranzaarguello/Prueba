package com.example.pruebae.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1")
@Controller
public class Rol {
    @Autowired
    RolRepository rolRepository;


    @GetMapping(value = "/rol")
    public ResponseEntity<Object> persona() {
        return ResponseEntity.ok().body(rolRepository.findAll());
    }
    @PostMapping(value = "/rol")
    public ResponseEntity<Object> insertarRol(@RequestBody RolEntity nuevoRol) {
        RolEntity rolGuardado = rolRepository.save(nuevoRol);
        return ResponseEntity.ok().body("Registro Exitoso");
    }

    @PutMapping(value = "/rol/{id}")
    public ResponseEntity<String> editarRol(@PathVariable Integer id, @RequestBody RolEntity rolActualizado) {

        return rolRepository.findById(id).map(rolExistente -> {
            rolExistente.setTipo(rolActualizado.getTipo());
           rolRepository.save(rolExistente);
            return ResponseEntity.ok().body("Rol actualizado exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping(value = "/rol/{id}")
    public ResponseEntity<String> eliminarRol(@PathVariable Integer id) {
        return rolRepository.findById(id).map(rol -> {
            rolRepository.deleteById(id);
            return ResponseEntity.ok("Rol eliminado exitosamente");
        }).orElseGet(() -> ResponseEntity.status(404).body("Rol  no encontrado"));
    }
}
