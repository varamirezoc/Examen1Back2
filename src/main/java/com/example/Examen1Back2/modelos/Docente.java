package com.example.Examen1Back2.modelos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "especialidad", unique = false, nullable = false)
    private  String especialidad;

    @OneToMany(mappedBy = "docente")
    @JsonManagedReference(value = "docente-curso")
    private List<Curso> cursos;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference(value = "docente-usuario")
    private Usuario usuario;

    public Docente() {
    }

    public Docente(Integer id, String especialidad, List<Curso> cursos, Usuario usuario) {
        this.id = id;
        this.especialidad = especialidad;
        this.cursos = cursos;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}