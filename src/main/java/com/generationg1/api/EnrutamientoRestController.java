package com.generationg1.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EnrutamientoRestController {
    //** Enrutamientos */
    //http://localhost:8080/usuario
    @RequestMapping("/usuario")
    public String usuario(){
        return "estamos en la url usuario";
    }

    @RequestMapping("/usuario/inscrito")
    public String inscrito(){
        return "estamos en la url usuario/inscrito";
    }

    @RequestMapping("/cliente/registrado")
    public String cliente(){
        return "Ruta de cliente";
    }

    @RequestMapping(value = "/proveedor/registrado", method = RequestMethod.GET)
    public String proveedor(){
        return "Ruta de proveedor";
    }
}

