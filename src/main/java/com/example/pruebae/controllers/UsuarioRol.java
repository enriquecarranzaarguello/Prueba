package com.example.pruebae.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1")
@Controller
public class UsuarioRol {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;



    @GetMapping(value = "/usuariorol")
    public ResponseEntity<Object> usuariorol() {
        return ResponseEntity.ok().body(usuarioRolRepository.findAll());
    }
    @PostMapping(value = "/usuariorol")
    public ResponseEntity<Object> insertarUsuariorol(@RequestBody UsuarioRolEntity nuevoUsuariorol) {
        UsuarioRolEntity usuariorolGuardado = usuarioRolRepository.save(nuevoUsuariorol);
        return ResponseEntity.ok().body("Registro Exitoso");
    }

    @PutMapping(value = "/usuariorol/{id}")
    public ResponseEntity<String> editarUsuariorol(@PathVariable Integer id, @RequestBody UsuarioRolEntity usuariorolActualizado) {

        return usuarioRolRepository.findById(id).map(usuariorolExistente -> {

            usuariorolExistente.setId_rol(usuariorolActualizado.getId_rol());
            usuariorolExistente.setId_usuario(usuariorolActualizado.getId_usuario());


            usuarioRolRepository.save(usuariorolExistente);
            return ResponseEntity.ok().body("Rol de Usuario actualizado exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping(value = "/usuariorol/{id}")
    public ResponseEntity<String> eliminarUsuariorol(@PathVariable Integer id) {
        return usuarioRolRepository.findById(id).map(usuariorol -> {
            usuarioRolRepository.deleteById(id);
            return ResponseEntity.ok("Rol de Usuario eliminado exitosamente");
        }).orElseGet(() -> ResponseEntity.status(404).body("Rol de Usuario no encontrado"));  // Si no se encuentra, devolver 404 con mensaje
    }
}
