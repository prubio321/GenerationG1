package com.generationg1.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    //ManytoMany (2 oneToMany)
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Usuario> listaUsuario;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    public Rol() {
    }

    public Rol(String nombre, String descripcion, List<Usuario> listaUsuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaUsuario = listaUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
