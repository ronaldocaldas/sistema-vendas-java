package com.kurtphpr.sistema.venda;

import java.util.List;

public interface VendaDAO {

	public void registra(Venda venda);

	public List<Venda> getLista();

	public void excluir(Venda venda);

}
