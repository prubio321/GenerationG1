package com.generationg1.models;

import javax.persistence.*;

@Entity
@Table(name="pelotas")
public class Pelota {
//variables
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String material;
    private String color;

    //constructor vacio

    public Pelota() {
    }

    //constructor parametros

    public Pelota(Long id, String marca, String material, String color) {
        this.id = id;
        this.marca = marca;
        this.material = material;
        this.color = color;
    }


    //getter and setter


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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
