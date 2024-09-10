package com.example.pruebae.controllers;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Builder
@Data
@Table ("rol")
public class RolEntity {
    @Id
    private Integer id;
    private String tipo;

}
