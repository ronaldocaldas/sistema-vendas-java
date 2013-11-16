package com.kurtphpr.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
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
		produtoRN.salvar(p3);

	}

	@After
	public void limpaBanco() {
		VendaRN vendaRN = new VendaRN();

		List<Venda> produtos = vendaRN.listar();

		for (Venda produto : produtos) {
			vendaRN.excluir(produto);

		}

	}

	@Test
	public void registraTest() {

		VendaRN vendaRN = new VendaRN();

		Venda venda1 = new Venda();
		venda1.setCliente(c1);
		venda1.setProduto(p1);
		venda1.setDataVenda(new Date());

		Venda venda2 = new Venda();
		venda2.setCliente(c2);
		venda2.setProduto(p2);
		venda2.setDataVenda(new Date());

		Venda venda3 = new Venda();
		venda3.setCliente(c3);
		venda3.setProduto(p3);
		venda3.setDataVenda(new Date());

		vendaRN.registraVenda(venda1);
		vendaRN.registraVenda(venda2);
		vendaRN.registraVenda(venda3);

		List<Venda> vendas = vendaRN.listar();

		assertEquals(3, vendas.size());

	}

}
