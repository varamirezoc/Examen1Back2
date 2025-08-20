package com.example.Examen1Back2.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre-curso", unique = false, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name="fk_docente", referencedColumnName = "id");
    @JsonBackReference(value = "docente-curso")
    Docente docente

    public Curso() {
    }

    public Curso(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


}
