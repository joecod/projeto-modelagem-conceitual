package com.joselemes.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselemes.cursomc.domain.Produto;
import com.joselemes.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	
	public Produto findById(Integer id) {
		return repo.findById(id).orElse(null);
	}
}
