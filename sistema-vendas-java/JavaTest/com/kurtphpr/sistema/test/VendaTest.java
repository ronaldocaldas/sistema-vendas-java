package com.kurtphpr.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kurtphpr.sistema.cliente.Cliente;
import com.kurtphpr.sistema.cliente.ClienteRN;
import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.produto.ProdutoRN;
import com.kurtphpr.sistema.venda.Venda;
import com.kurtphpr.sistema.venda.VendaRN;

public class VendaTest extends TestHeranca {

	Cliente c1;
	Cliente c2;
	Cliente c3;

	Produto p1;
	Produto p2;
	Produto p3;

	@Before
	public void setup() {
		c1 = new Cliente("34125365474", "teste1@mail", "Rua 1", "Cliente 1",
				new Date(), 2000);
		c2 = new Cliente("34125365474", "teste2@mail", "Rua 2", "Cliente 2",
				new Date(), 3000);
		c3 = new Cliente("34125365474", "teste3@mail", "Rua 3", "Cliente 3",
				new Date(), 4000);

		ClienteRN clienteRN = new ClienteRN();

		clienteRN.salvar(c1);
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);

		p1 = new Produto("lote", "Caderno", new Date(), 50, 7.0f);
		p2 = new Produto("lote2", "Regua", new Date(), 30, 2.5f);
		p3 = new Produto("fardo", "Papel", new Date(), 300, 1.5f);

		ProdutoRN produtoRN = new ProdutoRN();

		produtoRN.salvar(p1);
		produtoRN.salvar(p2);
		produtoRN.salvar(p2);

	}

	@Test
	public void registraTest() {

		VendaRN vendaRN = new VendaRN();

		vendaRN.registraVenda(c1, p1);
		vendaRN.registraVenda(c2, p2);
		vendaRN.registraVenda(c3, p3);

		List<Venda> vendas = vendaRN.listar();

		assertEquals(3, vendas.size());

	}

}
