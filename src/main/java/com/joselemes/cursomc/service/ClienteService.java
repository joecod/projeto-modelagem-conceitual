package com.joselemes.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselemes.cursomc.domain.Cliente;
import com.joselemes.cursomc.repositories.ClienteRepository;
import com.joselemes.cursomc.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	public Cliente findById(Integer id) {
		Cliente obj = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found with id = " + id));
		return obj;
	}
}
