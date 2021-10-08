package com.joselemes.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselemes.cursomc.domain.Produto;
import com.joselemes.cursomc.repositories.ProdutoRepository;
import com.joselemes.cursomc.service.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	
	public Produto findById(Integer id) {
		Produto obj = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found with id = " + id));
		return obj;
	}
}
