package com.kurtphpr.sistema.test;

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
		this.transacao = this.sessao.beginTransaction();
	}
	
	public void fechaConexao(){
		this.transacao.commit();
		
		try {
			if(this.sessao.isOpen()){
				this.sessao.close();
			}
			
		} catch (Exception e) {
			System.out.println("deu problema no fechamento da conexao : " +e.getMessage());
		}
	}
	
	
	@Test
	public void salvarProdutoTest(){
		Produto p1 = new Produto();
		p1.setDescricao("Produto Teste");
		p1.setEstoque(20);
		p1.setDataCadastro(new Date());
		p1.setUnidade("Quilo");
		p1.setValor(1.6f);
		
		abreConexao();
		this.sessao.save(p1);
		fechaConexao();
		
		assertNull(null);
		
		
	}
	
	

}
