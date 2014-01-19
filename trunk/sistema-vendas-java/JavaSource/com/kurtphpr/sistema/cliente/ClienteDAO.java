package com.kurtphpr.sistema.cliente;

import java.util.List;

public interface ClienteDAO {

	public void salvar(Cliente cliente);

	public List<Cliente> listar();

	public void excluir(Cliente cliente);

	public Cliente pesquisar(String string);

	public void alterar(Cliente cliente);

	public Cliente pesquisarPorCodigo(Integer codigoString);
}
