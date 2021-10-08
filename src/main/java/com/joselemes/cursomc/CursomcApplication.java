package com.joselemes.cursomc;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joselemes.cursomc.domain.Categoria;
import com.joselemes.cursomc.domain.Cidade;
import com.joselemes.cursomc.domain.Cliente;
import com.joselemes.cursomc.domain.Endereco;
import com.joselemes.cursomc.domain.Estado;
import com.joselemes.cursomc.domain.Pagamento;
import com.joselemes.cursomc.domain.PagamentoComBoleto;
import com.joselemes.cursomc.domain.PagamentoComCartao;
import com.joselemes.cursomc.domain.Pedido;
import com.joselemes.cursomc.domain.Produto;
import com.joselemes.cursomc.domain.enums.EstadoPagamento;
import com.joselemes.cursomc.domain.enums.TipoCliente;
import com.joselemes.cursomc.repositories.CidadeRepository;
import com.joselemes.cursomc.repositories.ClienteRepository;
import com.joselemes.cursomc.repositories.EnderecoRepository;
import com.joselemes.cursomc.repositories.EstadoRepository;
import com.joselemes.cursomc.repositories.PagamentoRepository;
import com.joselemes.cursomc.repositories.PedidoRepository;
import com.joselemes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Produto Categoria */
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		p1.getCategorias().addAll(List.of(cat1));
		p2.getCategorias().addAll(List.of(cat1, cat2));
		p3.getCategorias().addAll(List.of(cat1));
		
		produtoRepository.saveAll(List.of(p1, p2, p3));
		
		/* Cidade Estado */
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2= new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(List.of(c1));
		est2.getCidades().addAll(List.of(c2, c3));
				
		estadoRepository.saveAll(List.of(est1, est2));
		cidadeRepository.saveAll(List.of(c1, c2, c3));
		
		/* Cliente Endereço */
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "04671468611", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(List.of("33121264", "88928615"));
		
		Endereco e1 = new Endereco(null, "Av Dr Hélio Luiz da Costa", "386", "Apto 203", "Frei Eugenio", "38081100", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Fonseca", "46", "", "Merces", "38000000", cli1, c2);
		
		cli1.getEnderecos().addAll(List.of(e1, e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(List.of(e1, e2));
		
		/* Pedidos Pagamentos */
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("08/10/2021 16:17"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("31/10/2019 15:30"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("01/11/2019 12:01"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(List.of(ped1, ped2));
		
		pedidoRepository.saveAll(List.of(ped1, ped2));
		pagamentoRepository.saveAll(List.of(pagto1, pagto2));
	}

}
