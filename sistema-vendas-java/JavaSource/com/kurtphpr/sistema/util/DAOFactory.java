package com.kurtphpr.sistema.util;

import com.kurtphpr.sistema.cliente.ClienteDAO;
import com.kurtphpr.sistema.cliente.ClienteDAOHibernate;

public class DAOFactory {

	public static ClienteDAO criaClienteDAO() {
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		clienteDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return clienteDAOHibernate;
	}
}
