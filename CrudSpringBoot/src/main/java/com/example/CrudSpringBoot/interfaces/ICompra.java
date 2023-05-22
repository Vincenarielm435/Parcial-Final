package com.example.CrudSpringBoot.interfaces;

import com.example.CrudSpringBoot.modelo.Compra;
import org.springframework.data.repository.CrudRepository;

public interface ICompra extends CrudRepository<Compra, Integer> {
}

