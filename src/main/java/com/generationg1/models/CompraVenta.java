package com.generationg1.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compras_ventas")
public class CompraVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min=0) //Range <> Size(min=2) -99
    private Float monto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    //ManyToOne
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id") //pk de la otra entidad
    private Cliente cliente;

    //ManyToMany AutosVentas
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "autos_ventas",//nombre tabla
            joinColumns = @JoinColumn(name = "compra_venta_id"),//desde la entidad actual
            inverseJoinColumns = @JoinColumn(name = "auto_id")//la otra entidad o tabla
    )
    private List<Auto> autos;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    public CompraVenta() {
    }

    public CompraVenta(Float monto, Date fecha, Cliente cliente) {
        this.monto = monto;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
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
