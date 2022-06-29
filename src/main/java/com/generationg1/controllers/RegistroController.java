package com.generationg1.controllers;


import com.generationg1.models.Usuario;
import com.generationg1.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    //inyeccion de dependencias
    @Autowired
    UsuarioService usuarioService;

    //ruta por default
    @RequestMapping("")
    public String registro(@ModelAttribute("usuario") Usuario usuario) {
        //pasamos el objeto usuario vacio

        return "registro.jsp"; //pagina a desplegar
    }

    //ruta para capturar los datos del formulario, //localhost:8080/registro/usuario
    @PostMapping("/usuario/respaldo")
    public String registroUsuario(@RequestParam(value = "gato") String nombre,
                                  @RequestParam(value = "apellido") String apellido,
                                  @RequestParam(value = "edad") String edad
    ) {

        System.out.println(("parametro gato ") + nombre);
        System.out.println(("parametro apellido ") + apellido);
        System.out.println(("parametro edad ") + edad);

        return "registro.jsp"; //pagina usuario a desplegar

    }

    @PostMapping("/usuario")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                 BindingResult resultado,
                                 Model model) {
        if (resultado.hasErrors()) {//capturamos si existe un error en el ingreso de datos desde el jsp
            model.addAttribute("msgError", "Debe ingresar valores correctos");
            return "registro.jsp";
        } else {
            //capturamos el objeto con los atributos llenos
            System.out.println(usuario.getNombre() + " " + usuario.getApellido() + " " + usuario.getEdad());


            //enviar el objeto al service
            usuarioService.saveUsuario(usuario);

            return "index.jsp"; //pagina a desplegar
        }

    }


}
