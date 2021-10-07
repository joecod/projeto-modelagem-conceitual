package com.joselemes.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselemes.cursomc.domain.Categoria;
import com.joselemes.cursomc.repositories.CategoriaRepository;
import com.joselemes.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		String str = "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName();
		return obj.orElseThrow(() -> new ObjectNotFoundException(str));
	}

}
