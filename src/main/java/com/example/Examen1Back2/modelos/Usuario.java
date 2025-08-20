package com.example.Examen1Back2.modelos;
import com.example.Examen1Back2.ayudas.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo_electronico", length = 50, unique = true)
    private String correoElectronico;

    @Column(name = "contraseña", length = 10, unique = true, nullable = false)
    private String contraseña;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "TipoUsuario", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    //Estableciendo la relacion uno a uno con la tabla docente
    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "relaciondocenteusuario")
    private Docente docente;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoElectronico, String contraseña, String telefono, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}