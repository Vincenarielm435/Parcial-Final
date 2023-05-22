package com.example.CrudSpringBoot.controler;



import com.example.CrudSpringBoot.interfaceService.IPersonaService;
import com.example.CrudSpringBoot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controler {


    @Autowired
    private IPersonaService service;

    @GetMapping("/inicio")
    public String agregar(Model model){
        return "major";
    }
    @GetMapping("/servicios")
    public String ver(Model model){
        return "Servicios";
    }
    @GetMapping("/productos")
    public String ver2(Model model){
        return "Productos";
    }



    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona>personas= service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }






    @GetMapping("/formulario")
    public String agregar7(Model model){
        model.addAttribute("persona", new Persona());
        return "formulario";

    }@GetMapping("/modifica")
    public String agregar8(Model model){
        model.addAttribute("persona", new Persona());
        return "editador";
    }

    @PostMapping("/save")
    public String save(@Validated Persona p){
        service.save(p);
        return "redirect:/inicio";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona", persona);
        return "editador";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }



}
