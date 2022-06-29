package com.generationg1.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    //OneToMany
    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// protege la integridad de la data
    private List<CompraVenta> comprasVentas;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, List<CompraVenta> comprasVentas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.comprasVentas = comprasVentas;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
