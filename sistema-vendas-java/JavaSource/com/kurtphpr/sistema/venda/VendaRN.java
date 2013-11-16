package com.kurtphpr.sistema.venda;

import java.util.List;

import com.kurtphpr.sistema.util.DAOFactory;

public class VendaRN {
	private VendaDAO vendaDAO;

	public VendaRN() {
		this.vendaDAO = DAOFactory.criaVendaDAO();
	}
	public void registraVenda(Venda venda) {
		this.vendaDAO.registra(venda);

	}

	public List<Venda> listar() {
		return this.vendaDAO.getLista();
	}
	public void excluir(Venda venda) {
		this.vendaDAO.excluir(venda);
		
	}

}
