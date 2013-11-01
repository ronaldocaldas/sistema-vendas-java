package com.kurtphpr.sistema.util;

import com.kurtphpr.sistema.cliente.ClienteDAO;
import com.kurtphpr.sistema.cliente.ClienteDAOHibernate;
import com.kurtphpr.sistema.produto.ProdutoDAO;
import com.kurtphpr.sistema.produto.ProdutoDAOHibernate;

public class DAOFactory {

	public static ClienteDAO criaClienteDAO() {
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		clienteDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return clienteDAOHibernate;
	}

	public static ProdutoDAO criaProdutoDAO() {
		ProdutoDAOHibernate produtoDAOHibernate = new ProdutoDAOHibernate();
		produtoDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return produtoDAOHibernate;
	}
}
