package com.yeny.spring_boot_microservice2_compra.service;

import java.util.List;

import com.yeny.spring_boot_microservice2_compra.model.Compra;

// Interfaz que define los métodos que el servicio debe implementar
public interface CompraService {

    // Método para guardar una nueva compra
    Compra saveCompra(Compra compra);

    // Método para obtener todas las compras realizadas por un usuario
    List<Compra> findAllComprasOfUser(Long userId);
}
