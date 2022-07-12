package com.generationg1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;


    private String apellido;

    private Integer edad;

    private String email;

    @NotNull
    private String password;

    @Transient //no se crea en la tabla de base datos
    private String passwordConfirmacion;

    @Column(updatable= false)
    private Date createdAt;

    private Date updatedAt;

    //OneToOne
    @OneToOne(mappedBy ="usuario",cascade=CascadeType.ALL ,fetch=FetchType.LAZY)
    private Licencia licencia;

    //ManyToMany
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="roles_usuarios",//nombre tabla relacional
            joinColumns = @JoinColumn(name="usuario_id"),//desde la entidad actual
            inverseJoinColumns= @JoinColumn(name="rol_id")//la otra entidad o tabla
    )
    private List<Rol> roles;

    public Licencia getLicencia() {
        return licencia;
    }
    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }
    //constructores
    public Usuario() {
        super();
    }
    public Usuario(String nombre, String apellido, Integer edad,String password) {
        super();
        this.nombre = "serwlfjelwfhjlehjf";
        this.apellido = apellido;
        this.edad = edad;
        this.password= password;
    }
    //Getters& Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmacion() {
        return passwordConfirmacion;
    }
    public void setPasswordConfirmacion(String passwordConfirmacion) {
        this.passwordConfirmacion = passwordConfirmacion;
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