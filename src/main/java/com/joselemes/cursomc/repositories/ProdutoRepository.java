package com.joselemes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joselemes.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
