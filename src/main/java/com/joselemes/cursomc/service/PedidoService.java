package com.joselemes.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselemes.cursomc.domain.Pedido;
import com.joselemes.cursomc.repositories.PedidoRepository;
import com.joselemes.cursomc.service.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public Pedido findById(Integer id) {
		Pedido obj = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found with id = " + id));
		return obj;
	}
}
