package com.joselemes.cursomc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joselemes.cursomc.domain.Categoria;
import com.joselemes.cursomc.domain.Produto;
import com.joselemes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		p1.getCategorias().addAll(List.of(cat1));
		p2.getCategorias().addAll(List.of(cat1, cat2));
		p3.getCategorias().addAll(List.of(cat1));
		  
		produtoRepository.saveAll(List.of(p1, p2, p3));
		
	}

}
