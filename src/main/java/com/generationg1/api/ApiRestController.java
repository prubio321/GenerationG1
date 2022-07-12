package com.generationg1.api;

import com.generationg1.models.Auto;
import com.generationg1.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class ApiRestController {

    @Autowired //inyeccion de dependencia de clase
    AutoService autoService;

    //localhost:8080/api/obtener/autos
    @RequestMapping("/obtener/autos")
    public List<Auto> obtenerListaAutos(){
        List<Auto> listaAutos = autoService.findAll();
        return listaAutos;
    }

    @RequestMapping("/crear/autos")
    public Auto crearAutos(Auto auto){
        autoService.guardarAuto(auto);;
        return auto;
    }

    @RequestMapping("/editar/autos")
    public Auto editarAutos(Auto auto){
        autoService.guardarAuto(auto);;
        return auto;
    }

    @RequestMapping("/eliminarById/autos")
    public long eliminarById(long id){
        autoService.eliminarPorId(id);
        return id;
    }

    @RequestMapping("/getAutoById/autos")
    public Auto getAutoById(long id){
        Auto auto = autoService.buscarId(id);
        return auto;
    }

    //API (JSON)..
}
