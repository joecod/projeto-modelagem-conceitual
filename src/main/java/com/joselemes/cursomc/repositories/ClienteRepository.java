package com.joselemes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joselemes.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
