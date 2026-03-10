package com.example.proyecto.thymeleaf.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.proyecto.thymeleaf.model.dto.UserDTO;
import com.example.proyecto.thymeleaf.model.entity.Usuario;
import com.example.proyecto.thymeleaf.repository.UsuarioRepository;

@Service
public class UserService {
    private final UsuarioRepository repo;
    private final ModelMapper mapper;

    public UserService(UsuarioRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public UserDTO findById(Long id) {
        Usuario user = repo.findById(id).orElseThrow();
        return mapper.map(user, UserDTO.class);
    }

    public List<UserDTO> findAll() {
        return repo.findAll()
            .stream()
            .map(u -> mapper.map(u, UserDTO.class))
            .collect(Collectors.toList());
    }
}