package com.example.proyecto.thymeleaf.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "status = 0")
@SQLDelete(sql = "UPDATE user SET status = 1 WHERE id=?")
public class Proceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String descripcion;
    private String categoria;
    private String status;

    @ManyToOne
    @JoinColumn(
        name = "id_empresa",
        referencedColumnName = "id",
        unique = false,
        nullable = false
    )
    private Empresa empresa;

    @OneToMany(mappedBy = "procesos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activiad> comments = new ArrayList<>();
}
