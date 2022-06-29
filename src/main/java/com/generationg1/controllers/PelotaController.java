package com.generationg1.controllers;
import com.generationg1.models.Pelota;
import com.generationg1.services.PelotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;


    @Controller
    @RequestMapping("/pelota")
    public class PelotaController {
        @Autowired// inyeccion de dependencia de clase
        PelotaService pelotaService;

        @RequestMapping("")
        public String registroPelota(@ModelAttribute("pelota") Pelota pelota) {

            return "registroPelota.jsp"; //pagina a desplegar
        }

        @PostMapping("registro")
        public String guardarPelota(@Valid @ModelAttribute("pelota") Pelota pelota,
                                  BindingResult resultado,
                                  Model model) {
            if (resultado.hasErrors()) {//capturamos si existe un error en el ingreso de datos desde el jsp
                model.addAttribute("msgError", "Debe ingresar valores correctos");
                return "registroPelota.jsp";
            } else {
                //enviar el objeto al service
                pelotaService.savePelota(pelota);
                //obtener una lista de pelotas
                List<Pelota> listaPelotas = pelotaService.findAll();
                //pasamos la lista de pelotas al jsp
                model.addAttribute("listaPelotas", listaPelotas);
                return "mostrarPelotas.jsp"; //pagina a desplegar
            }
        }

        //solo mostrar el listado de pelotas
        @RequestMapping("/mostrar")
        public String mostrar(Model model) {
            //obtener una lista de pelotas
            List<Pelota> listapelotas = pelotaService.findAll();
            //pasamos la lista de pelotas al jsp
            model.addAttribute("listaPelotas", listapelotas);
            return "mostrarPelotas.jsp"; //pagina a desplegar
        }

        @RequestMapping("/editar/{id}")
        public String editar(@PathVariable("id") Long id, Model model) {
            System.out.println("el id es: " + id);
            Pelota pelota = pelotaService.buscarId(id);//buscar el objeto en el sql
            model.addAttribute("pelota", pelota);//pasar al jsp

            return "editarPelota.jsp";//redireccionar a otra url o path
        }

        //localhost:8080/pelota/actualizar/{id} -> //actualizar para la persistencia en la bd
        @PostMapping("/actualizar/{id}")
        public String actualizarPelota(@PathVariable("id") Long id, @Valid @ModelAttribute("pelota") Pelota pelota,
                                     BindingResult resultado,
                                     Model model) {
            System.out.println("el id al actualizar es: "+id);


            if (resultado.hasErrors()) {//capturamos si existe un error en el ingreso de datos desde el jsp
                model.addAttribute("msgError", "Debe ingresar valores correctos");
                return "editarPelota.jsp";
            } else {
                pelota.setId(id);//-> agregar el id al objeto
                //enviar el objeto al service
                pelotaService.savePelota(pelota);
                //obtener una lista de pelotas
                List<Pelota> listaPelotas = pelotaService.findAll();
                //pasamos la lista de pelotas al jsp
                model.addAttribute("listaPelotas", listaPelotas);
                return "mostrarPelotas.jsp"; //pagina a desplegar
            }
        }
    }


