package com.example.pruebae.controllers;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@Table ("usuario")

public class UserEntity {
    @Id
    private Integer id;
    private String usuario;
    private String contrasena;
    private String estado;

}
