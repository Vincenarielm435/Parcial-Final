package com.example.CrudSpringBoot.controler;



import com.example.CrudSpringBoot.interfaceService.ICompraService;
import com.example.CrudSpringBoot.modelo.Compra;
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
public class CompraControler {


    @Autowired
    private ICompraService service;



    @GetMapping("/listarC")
    public String listarC(Model model){
        List<Compra>compra= service.listarC();
        model.addAttribute("compra", compra);
        return "verProductos";
    }






    @GetMapping("/formularioC")
    public String agregarC(Model model){
        model.addAttribute("compra", new Compra());
        return "formularioC";

    }
    @PostMapping("/saveC")
    public String saveC(@Validated Compra c){
        service.saveC(c);
        return "redirect:/listarC";
    }

    @GetMapping("/editarC/{id}")
    public String editarC(@PathVariable int id, Model model){
        Optional<Compra> compra = service.listarIdC(id);
        model.addAttribute("compra", compra);
        return "formularioC";
    }

    @GetMapping("/eliminarC/{id}")
    public String deleteC(@PathVariable int id){
        service.deleteC(id);
        return "redirect:/listarC";
    }



}