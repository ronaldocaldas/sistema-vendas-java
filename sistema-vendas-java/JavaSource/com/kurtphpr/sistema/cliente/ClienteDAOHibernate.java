package com.kurtphpr.sistema.cliente;

import org.hibernate.Session;

public class ClienteDAOHibernate implements ClienteDAO {

	private Session sessao;
	
	@Override
	public void salvar(Cliente cliente) {
		this.sessao.save(cliente);

	}

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

}
