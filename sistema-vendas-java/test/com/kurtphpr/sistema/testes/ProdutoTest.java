package com.kurtphpr.sistema.testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.util.HibernateUtil;

public class ProdutoTest {

	private Session sessao;
	private Transaction transacao;
	
	
	public void abreConexao(){
		this.sessao = HibernateUtil.getSession().getCurrentSession();
		this.transacao  = this.sessao.beginTransaction();
	}
	
	public void fechaConexao(){
		this.sessao.close();
	}
	
	public Produto buscarProduto(Integer codigo){
		
		this.sessao = HibernateUtil.getSession().getCurrentSession();
		this.transacao  = this.sessao.beginTransaction();
		Produto teste  = (Produto) this.sessao.get(Produto.class, codigo);
		return teste;
	}
	
	@Test
	public void salvarTest(){
		Produto p1 = new Produto();
		p1.setDescricao("Produto Test");
		p1.setEstoque(2);
		p1.setUnidade("Quilo");
		p1.setDataCadastro(new Date());
		
	
//		this.sessao.save(p1);
//		this.transacao.commit();
		
		
		Produto p2 =  buscarProduto(1);
		this.sessao.close();
		assertEquals(p2.getId(), Integer.valueOf(1));
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
