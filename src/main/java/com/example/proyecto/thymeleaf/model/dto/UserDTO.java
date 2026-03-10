package com.example.proyecto.thymeleaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    // no incluimos email por ejemplo
    // getters/setters
}