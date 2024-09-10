package com.example.pruebae.controllers;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@Table ("usuariorol")
public class UsuarioRolEntity {
    @Id
    private Integer id;
    private Integer id_rol;
    private Integer id_usuario;

}
