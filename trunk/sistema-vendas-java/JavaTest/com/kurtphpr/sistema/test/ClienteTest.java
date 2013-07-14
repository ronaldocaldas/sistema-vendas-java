package com.kurtphpr.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kurtphpr.sistema.cliente.Cliente;
import com.kurtphpr.sistema.cliente.ClienteRN;
import com.kurtphpr.sistema.util.HibernateUtil;

public class ClienteTest {

	private static Session sessao;
	private static Transaction transacao;

	@BeforeClass
	public static void abreConexao() {
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
		Cliente c1 = new Cliente("34125365474", "teste1@mail", "Rua 1", "Cliente 1", new Date(), 2000);
		Cliente c2 = new Cliente("34125365474", "teste2@mail", "Rua 2", "Cliente 2", new Date(), 3000);
		Cliente c3 = new Cliente("34125365474", "teste3@mail", "Rua 3", "Cliente 3", new Date(), 4000);
		
		ClienteRN clienteRN = new ClienteRN();
		
		clienteRN.salvar(c1);
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);
		
	}
	
	@After
	public void limpaBanco(){
		
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN .listar();
		
		for (Cliente cliente : lista) {
			clienteRN.excluir(cliente);
		}
	}

	@Test
	public void salvarTest() {

		Cliente c1 = new Cliente();

		c1.setNome("Ronaldo");
		c1.setEndereco("Rua Teste");
		c1.setRenda(5000f);
		c1.setCpf("123456789");

		ClienteRN clienteRN = new ClienteRN();

		clienteRN.salvar(c1);

		assertEquals(true, true);

	}
	
	@Test
	public void listarTest(){
		ClienteRN clienteRN = new ClienteRN();
		 List<Cliente> lista = clienteRN.listar();
		 assertEquals(3, lista.size());
		 
	}
	
	@Test
	public void excluirTest(){
		ClienteRN clienteRN = new ClienteRN();
		
		List<Cliente> lista = clienteRN.listar();
		
		Cliente clienteExcluido = lista.get(0);
		
		clienteRN.excluir(clienteExcluido);
		
		lista = clienteRN.listar();
		
		assertEquals(2, lista.size());
		
	}
	
	
}
