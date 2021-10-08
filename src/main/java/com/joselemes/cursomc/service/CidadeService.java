package com.joselemes.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselemes.cursomc.domain.Cidade;
import com.joselemes.cursomc.repositories.CidadeRepository;
import com.joselemes.cursomc.service.exceptions.ResourceNotFoundException;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository repo;
	
	public Cidade findById(Integer id) {
		Cidade obj = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found with id = " + id));
		return obj;
	}
}
