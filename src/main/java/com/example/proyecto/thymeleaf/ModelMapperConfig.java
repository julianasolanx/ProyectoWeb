package com.example.proyecto.thymeleaf;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        // configuración opcional, ej. ignorar nulls, políticas de matching, etc.
        return mapper;
    }
}
