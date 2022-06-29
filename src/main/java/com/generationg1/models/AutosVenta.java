package com.generationg1.models;

import javax.persistence.*;
import java.util.Date;

//tabla relacional
@Entity
@Table(name = "autos_ventas")
public class AutosVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private Float subtotal;
    private Date fecha;

    /**ManyToMany = 2 ManyToOne*/
    //ManyToOne Auto
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="auto_id") //pk de la otra entidad
    private Auto auto;

    //ManyToOne CompraVenta
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="compra_venta_id") //pk de la otra entidad
    private CompraVenta compraVenta;

    public AutosVenta() {
    }

    public AutosVenta(Integer cantidad, Float subtotal, Date fecha) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public CompraVenta getCompraVenta() {
        return compraVenta;
    }

    public void setCompraVenta(CompraVenta compraVenta) {
        this.compraVenta = compraVenta;
    }
}
