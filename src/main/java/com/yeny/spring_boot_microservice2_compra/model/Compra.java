package com.yeny.spring_boot_microservice2_compra.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El userId no puede ser nulo y debe ser un número positivo
    @NotNull(message = "El ID de usuario es obligatorio")
    @Positive(message = "El ID de usuario debe ser un número positivo")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // El inmuebleId no puede ser nulo y debe ser un número positivo
    @NotNull(message = "El ID de inmueble es obligatorio")
    @Positive(message = "El ID de inmueble debe ser un número positivo")
    @Column(name = "inmueble_id", nullable = false)
    private Long inmuebleId;

    // El título no puede estar vacío ni solo espacios
    @NotBlank(message = "El título de la compra es obligatorio")
    @Size(max = 200, message = "El título no puede superar 200 caracteres")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    // El precio debe ser un valor mayor que cero
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    @Column(name = "precio", nullable = false)
    private Double precio;


    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;
}