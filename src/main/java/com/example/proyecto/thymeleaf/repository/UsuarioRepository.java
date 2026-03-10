package com.example.proyecto.thymeleaf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.example.proyecto.thymeleaf.model.dto.UserDTO;
import com.example.proyecto.thymeleaf.model.entity.Usuario;;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<Usuario> findByEmailJPQL(@Param("email") String email);

    // Retorno a DTO usando constructor expression
    @Query("SELECT new com.example.dto.UserSummary(u.id, u.names, u.email) FROM User u WHERE u.company.code = :code")
    List<UserDTO> findSummariesByCompanyCode(@Param("code") String companyCode);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.status = :status WHERE u.id = :id")
    int updateStatus(@Param("id") Long id, @Param("status") String status);

}