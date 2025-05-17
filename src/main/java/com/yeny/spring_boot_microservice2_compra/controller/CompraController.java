package com.yeny.spring_boot_microservice2_compra.controller;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeny.spring_boot_microservice2_compra.model.Compra;
import com.yeny.spring_boot_microservice2_compra.service.CompraService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// convierte la clase en un controlador REST (retorna JSON por defecto)
@RestController
@RequestMapping("/api/compra")
public class CompraController {

    // Inyecta automáticamente una instancia de CompraService (capa de lógica de negocio)
    @Autowired
    private CompraService compraService;
/* 
    // Endpoint para guardar una nueva compra (POST /api/compra)
    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra) {
        // Llama al servicio para guardar la compra y retorna un ResponseEntity con código 201 (CREATED)
        return new ResponseEntity<>(compraService.saveCompra(compra), HttpStatus.CREATED);
    }
*/

    @PostMapping
    public ResponseEntity<?> saveCompra(@Valid @RequestBody Compra compra,BindingResult result) {
        // Si hay errores de validación, construye un mapa de mensajes y devuelve 400
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->
                errores.put(err.getField(), err.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }
        // Setea fecha automática
        compra.setFechaCompra(LocalDateTime.now());
        Compra guardada = compraService.saveCompra(compra);
        return new ResponseEntity<>(guardada, HttpStatus.CREATED);
    }
   
   
    //Endpoint para obtener todas las compras de un usuario (GET /api/compra/{userId})
    @GetMapping("{userId}")
    public ResponseEntity<?> getAllComprasOfUser(@PathVariable Long userId) {
        // Llama al servicio y devuelve una lista de compras del usuario con código 200 (OK)
        return ResponseEntity.ok(compraService.findAllComprasOfUser(userId));
    }
}

