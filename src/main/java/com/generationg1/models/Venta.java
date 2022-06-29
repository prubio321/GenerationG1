package com.generationg1.models;

import javax.persistence.Column;
import java.util.Date;

public class Venta {
    @Column(updatable = false)//la columna nunca se va a actualizar
    private Date createdAt;
    private Date updatedAt;


}
