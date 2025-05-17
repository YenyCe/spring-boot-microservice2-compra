package com.yeny.spring_boot_microservice2_compra.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeny.spring_boot_microservice2_compra.model.Compra;
import com.yeny.spring_boot_microservice2_compra.reposiroty.CompraRepository;

// Marca esta clase como un componente de servicio de Spring
// Aquí se implementa la lógica relacionada a las compras
@Service
public class CompraServiceImpl implements CompraService {

    // Inyecta el repositorio para acceder a la base de datos
    @Autowired
    private CompraRepository compraRepository;

    // Guarda una compra en la base de datosy también le asigna la fecha actual al campo fechaCompra
    @Override
    public Compra saveCompra(Compra compra) {
        compra.setFechaCompra(LocalDateTime.now()); // Asigna la fecha y hora actual
        return compraRepository.save(compra); // Guarda en la base de datos
    }

    // Obtiene todas las compras realizadas por un usuario específico (por su ID)
    @Override
    public List<Compra> findAllComprasOfUser(Long userId) {
        return compraRepository.findAllByUserId(userId); // Consulta filtrando por el ID del usuario
    }
}
