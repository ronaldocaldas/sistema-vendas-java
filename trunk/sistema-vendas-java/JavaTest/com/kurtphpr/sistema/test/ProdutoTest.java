package com.kurtphpr.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.util.HibernateUtil;

public class ProdutoTest {

	private static Session sessao;
	private static Transaction transacao;

	@BeforeClass
	public  static void abreConexao() {
		sessao = HibernateUtil.getSession().getCurrentSession();
		transacao = sessao.beginTransaction();
	}

	@AfterClass
	public static void fechaConexao() {

		try {

			transacao.commit();

		} catch (Throwable e) {
			System.out.println("deu problema no commit : " + e.getMessage());
		} finally {
			try {
				if (sessao.isOpen()) {
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("Deu erro no fechamanto da sess‹o"
						+ e2.getMessage());
			}

		}
	}

	@Before
	public void setup(){
		Produto p1 = new Produto("lote", "Caderno", new Date(), 50, 7.0f);
		Produto p2 = new Produto("lote2", "Regua", new Date(), 30, 2.5f);
		Produto p3 = new Produto("fardo", "Papel", new Date(), 300, 1.5f);
		Produto p4 = new Produto("edicao", "Livro", new Date(), 10, 30.0f);
		Produto p5 = new Produto("caixa", "Caneta", new Date(), 90, 1.5f);
		
		
		sessao.save(p1);
		sessao.save(p2);
		sessao.save(p3);
		sessao.save(p4);
		sessao.save(p5);
		
	}
	
	@After
	public void limpaBanco(){
		Criteria lista = sessao.createCriteria(Produto.class);
		@SuppressWarnings("unchecked")
		List<Produto> produtos = lista.list();
		
		for (Produto produto : produtos) {
			sessao.delete(produto);
			
		}
	}
	
	
	@Test
	public void salvarProdutoTest() {
		
		Query consulta = pesquisar("Re");
		Produto produtoPesquisado = (Produto) consulta.uniqueResult();
		
		assertEquals("lote2", produtoPesquisado.getUnidade());

	}
	
	@Test
	public void listaProdutosTest(){
		
		Criteria lista = sessao.createCriteria(Produto.class);
		@SuppressWarnings("unchecked")
		List<Produto> produtos = lista.list();
		
		assertEquals(5, produtos.size());
		
		
	}
	
	@Test
	public void excluirProdutoTest(){
		Query consulta = pesquisar("Papel");
		Produto produtoDeletado = (Produto) consulta.uniqueResult();
		sessao.delete(produtoDeletado);
		
		produtoDeletado = (Produto) consulta.uniqueResult();
		
		assertNull(produtoDeletado);
		
		
	}
	
	@Test
	public void alteracaoProdutoTest(){
		Query consulta = pesquisar("Livro");
		Produto produtoAlterado = (Produto) consulta.uniqueResult();
		produtoAlterado.setEstoque(100);
		
		sessao.update(produtoAlterado);
		
		produtoAlterado = (Produto) consulta.uniqueResult();
		
		assertEquals(100, produtoAlterado.getEstoque().intValue());
		
	}

	private Query pesquisar(String parametro) {
		String sql = "from Produto p where p.descricao like :descricao";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("descricao", "%"+parametro+"%");
		return consulta;
	}

}
