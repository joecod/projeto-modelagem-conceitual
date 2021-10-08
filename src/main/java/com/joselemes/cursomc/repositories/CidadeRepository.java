package com.joselemes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joselemes.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
