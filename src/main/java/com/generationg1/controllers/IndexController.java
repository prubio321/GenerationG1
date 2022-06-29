package com.generationg1.controllers;

import com.generationg1.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //http://localhost:8080/
    @RequestMapping("/")// anotacion para capturar las rutas
    public String index(Model model){
        model.addAttribute("apellidos", "Rubio Herrera");
        model.addAttribute("nombres", "Paulino Rogers");
        model.addAttribute("edad", 28);
        model.addAttribute("correo", "p.rubioh321@gmail.com");
        model.addAttribute("telefono", "+56990367575");
        model.addAttribute("direccion", "Thiare 1099");

        //instancia de usuario
        Usuario usuario = new Usuario();
        //pasando el objeto a la vista (JSP)
        model.addAttribute("usuario", usuario);

        return "index.jsp";
    }

}
