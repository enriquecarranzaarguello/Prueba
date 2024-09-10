package com.example.pruebae.controllers;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@Table ("persona")
public class PersonaEntity {
    @Id
    private Integer id;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String pais;
    private String direccion;
}
