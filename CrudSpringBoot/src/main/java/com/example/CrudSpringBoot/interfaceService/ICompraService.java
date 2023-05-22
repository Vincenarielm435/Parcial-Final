package com.example.CrudSpringBoot.interfaceService;

import com.example.CrudSpringBoot.modelo.Compra;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.example.Ruta"})
public interface ICompraService {

    public List<Compra>listarC();
    public Optional<Compra>listarIdC(int id);
    public int saveC (Compra c);
    public void deleteC(int id);

}
