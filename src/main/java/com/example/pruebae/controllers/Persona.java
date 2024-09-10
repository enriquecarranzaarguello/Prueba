package com.example.pruebae.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1")
@Controller
public class Persona {
    @Autowired
    PersonaRepository personaRepository;


    @GetMapping(value = "/persona")
    public ResponseEntity<Object> persona() {
        return ResponseEntity.ok().body(personaRepository.findAll());
    }
    @PostMapping(value = "/persona")
    public ResponseEntity<Object> insertarPersona(@RequestBody PersonaEntity nuevoPersona) {
        PersonaEntity personaGuardado = personaRepository.save(nuevoPersona);
        return ResponseEntity.ok().body("Registro Exitoso");
    }

    @PutMapping(value = "/persona/{id}")
    public ResponseEntity<String> editarPersona(@PathVariable Integer id, @RequestBody PersonaEntity personaActualizado) {

        return personaRepository.findById(id).map(personaExistente -> {

            personaExistente.setNombres(personaActualizado.getNombres());
            personaExistente.setApellidos(personaActualizado.getApellidos());
            personaExistente.setSexo(personaActualizado.getSexo());
            personaExistente.setPais(personaActualizado.getPais());
            personaExistente.setDireccion(personaActualizado.getDireccion());

            personaRepository.save(personaExistente);
            return ResponseEntity.ok().body("Persona actualizada exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping(value = "/persona/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Integer id) {
        return personaRepository.findById(id).map(persona -> {
            personaRepository.deleteById(id);
            return ResponseEntity.ok("Persona eliminada exitosamente");
        }).orElseGet(() -> ResponseEntity.status(404).body("persona no encontrado"));
    }
}
