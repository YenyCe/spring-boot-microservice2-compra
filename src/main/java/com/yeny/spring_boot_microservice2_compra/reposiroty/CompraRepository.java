package com.yeny.spring_boot_microservice2_compra.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yeny.spring_boot_microservice2_compra.model.Compra;

public interface CompraRepository  extends JpaRepository<Compra,Long>
{

    List<Compra> findAllByUserId(Long userId);
}
