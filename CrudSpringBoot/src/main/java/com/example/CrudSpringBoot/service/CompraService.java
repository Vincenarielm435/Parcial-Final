package com.example.CrudSpringBoot.service;

import com.example.CrudSpringBoot.interfaceService.ICompraService;
import com.example.CrudSpringBoot.interfaces.ICompra;
import com.example.CrudSpringBoot.modelo.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private ICompra data;

    @Override
    public List<Compra> listarC() {
        return (List<Compra>) data.findAll();
    }

    @Override
    public Optional<Compra> listarIdC(int id) {

        return data.findById(id);
    }

    @Override
    public int saveC(Compra c) {
        int res = 0;
        Compra compra = data.save(c);
        if(!compra.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void deleteC(int id) {
        data.deleteById(id);
    }
}
