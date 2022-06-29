package com.generationg1.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")//establecer el inicio de ruta por defecto
public class ParametrosRestController {
    //localhost:8080/api?fecha=20220613
    @RequestMapping("")
    public String fecha(@RequestParam(value = "fecha") String fecha) {// variable que quiero capturar

        return "La fecha es: " + fecha;
    }

    //localhost:8080/api/seccion?modulo=3&seccion5
    //deben estar los 2 parametros, son conmutativos
    @RequestMapping("/seccion")
    public String seccion(@RequestParam(value = "modulo") String modulo,// variable que quiero capturar
                          @RequestParam(value = "seccion") String seccion) {

        return "El modulo es: " + modulo + "La seccion es: " + seccion;
    }

    /**
     * rutas con parametros no obligatorios
     */
    //Si el parametro no es pasado se ingresa un null
    //localhost:8080/api/date?anio=2022&mes=6&dia=13
    @RequestMapping("/date")
    public String capturarParametros(@RequestParam(value = "anio", required = false) String anio,
                                     @RequestParam(value = "mes", required = false) String mes,
                                     @RequestParam(value = "dia", required = false) String dia
    ) {
        if(anio !=null){
            System.out.println("El año es "+anio);
        }
        if(mes !=null){
            System.out.println("El mes es "+mes);
        }
        if(dia !=null){
            System.out.println("El dia es "+dia);
        }

        return "La fecha es: "+anio+mes+dia;
    }
}
