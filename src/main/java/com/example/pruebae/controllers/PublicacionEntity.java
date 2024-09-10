package com.example.pruebae.controllers;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@Table ("publicacion")
public class PublicacionEntity {
    @Id
    private Integer id;
    private Integer id_persona;
    private String cuerpo;

}
