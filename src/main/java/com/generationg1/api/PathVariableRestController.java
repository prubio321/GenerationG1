package com.generationg1.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/var") //localhost:8080/var -> path por default
public class PathVariableRestController {
    /**
     * capturar variables desde la ruta o path
     */

    //localhost:8080/var/anio/2022/mes/6/dia/13
    @RequestMapping("fecha/{a}/{m}/{d}")//rutas
    public String capturarVariablesPath(@PathVariable("a") String anio,
                                        @PathVariable("m") String mes,
                                        @PathVariable("d") String dia
    ) {

        return "La fecha es "+anio+"/"+mes+"/"+dia;
    }
}
