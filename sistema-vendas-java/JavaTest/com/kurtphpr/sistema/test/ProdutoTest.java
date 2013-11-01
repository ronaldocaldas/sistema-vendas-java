package com.kurtphpr.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.produto.ProdutoRN;

public class ProdutoTest extends TestHeranca {

	@Before
	public void setup() {
		Produto p1 = new Produto("lote", "Caderno", new Date(), 50, 7.0f);
		Produto p2 = new Produto("lote2", "Regua", new Date(), 30, 2.5f);
		Produto p3 = new Produto("fardo", "Papel", new Date(), 300, 1.5f);
		Produto p4 = new Produto("edicao", "Livro", new Date(), 10, 30.0f);
		Produto p5 = new Produto("caixa", "Caneta", new Date(), 90, 1.5f);

		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(p1);
		produtoRN.salvar(p2);
		produtoRN.salvar(p3);
		produtoRN.salvar(p4);
		produtoRN.salvar(p5);

	}

	@After
	public void limpaBanco() {
		// Criteria lista = sessao.createCriteria(Produto.class);
		// @SuppressWarnings("unchecked")

		ProdutoRN produtoRN = new ProdutoRN();

		List<Produto> produtos = produtoRN.listar();

		for (Produto produto : produtos) {
			produtoRN.excluir(produto);

		}

	}

	@Test
	public void salvarProdutoTest() {

		// Query consulta = pesquisar("Re");
		// Produto produtoPesquisado = (Produto) consulta.uniqueResult();
		//
		ProdutoRN produtoRN = new ProdutoRN();

		Produto produtoSalvo = new Produto("lote33", "Apontador", new Date(),
				110, 1.0f);

		produtoRN.salvar(produtoSalvo);

		Produto produtoPesquisado = produtoRN.pesquisarPorNome("Apo");

		assertEquals("lote33", produtoPesquisado.getUnidade());

	}

	@Test
	public void listaProdutosTest() {

		// Criteria lista = sessao.createCriteria(Produto.class);
		// @SuppressWarnings("unchecked")
		// List<Produto> produtos = lista.list();
		//
		ProdutoRN produtoRN = new ProdutoRN();
		List<Produto> produtos = produtoRN.listar();

		assertEquals(5, produtos.size());

	}

	// @Test
	// public void excluirProdutoTest(){
	// Query consulta = pesquisar("Papel");
	// Produto produtoDeletado = (Produto) consulta.uniqueResult();
	// sessao.delete(produtoDeletado);
	//
	// produtoDeletado = (Produto) consulta.uniqueResult();
	//
	// assertNull(produtoDeletado);
	//
	//
	// }

	// @Test
	// public void alteracaoProdutoTest(){
	// Query consulta = pesquisar("Livro");
	// Produto produtoAlterado = (Produto) consulta.uniqueResult();
	// produtoAlterado.setEstoque(100);
	//
	// sessao.update(produtoAlterado);
	//
	// produtoAlterado = (Produto) consulta.uniqueResult();
	//
	// assertEquals(100, produtoAlterado.getEstoque().intValue());
	//
	// }

	// private Query pesquisar(String parametro) {
	// String sql = "from Produto p where p.descricao like :descricao";
	// Query consulta = sessao.createQuery(sql);
	// consulta.setString("descricao", "%"+parametro+"%");
	// return consulta;
	// }

}
