package com.example.pruebae.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/v1")
@Controller
public class Auth {
    @Autowired
    UserRepository userRepository;



    @GetMapping(value = "/usuarios")
    public ResponseEntity<Object> usuarios() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
    @PostMapping(value = "/usuarios")
    public ResponseEntity<Object> insertarUsuario(@RequestBody UserEntity nuevoUsuario) {
        // Guardar el nuevo usuario en la base de datos
        UserEntity usuarioGuardado = userRepository.save(nuevoUsuario);
        return ResponseEntity.ok().body("Registro Exitoso");
    }

    @PutMapping(value = "/usuarios/{id}")
    public ResponseEntity<String> editarUsuario(@PathVariable Integer id, @RequestBody UserEntity usuarioActualizado) {

        return userRepository.findById(id).map(usuarioExistente -> {

            usuarioExistente.setUsuario(usuarioActualizado.getUsuario());
            usuarioExistente.setContrasena(usuarioActualizado.getContrasena());
            usuarioExistente.setEstado(usuarioActualizado.getEstado());

            userRepository.save(usuarioExistente);
            return ResponseEntity.ok().body("Usuario actualizado exitosamente");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping(value = "/usuarios/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id) {
                return userRepository.findById(id).map(usuario -> {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        }).orElseGet(() -> ResponseEntity.status(404).body("Usuario no encontrado"));  // Si no se encuentra, devolver 404 con mensaje
    }
}
