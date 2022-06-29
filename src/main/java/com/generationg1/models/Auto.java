package com.generationg1.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Float velocidad;
    private String color;
    private Float valor;

    //ManyToMany AutosVentas
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="autos_ventas",//nombre tabla relacional
            joinColumns = @JoinColumn(name="auto_id"),//desde la entidad actual
            inverseJoinColumns= @JoinColumn(name="compra_venta_id")//la otra entidad o tabla
    )
    private List<CompraVenta> comprasVentas;

    @Column(updatable= false)
    private Date createdAt;
    private Date updatedAt;


    public Auto() {
    }

    public Auto(String marca, String modelo, Float velocidad, String color, Float valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.color = color;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Float velocidad) {
        this.velocidad = velocidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public List<CompraVenta> getComprasVentas() {
        return comprasVentas;
    }

    public void setComprasVentas(List<CompraVenta> comprasVentas) {
        this.comprasVentas = comprasVentas;
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