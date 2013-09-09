package com.kurtphpr.sistema.cliente;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {

	private Cliente clienteSelecionado = new Cliente();

	private List<Cliente> lista = null;

	public void salvar() {
		ClienteRN clienteRN = new ClienteRN();
		clienteSelecionado.setDataCadastro(new Date());
		if (this.clienteSelecionado.getId() != null	&& this.clienteSelecionado.getId() != 0) {
			clienteRN.alterar(this.clienteSelecionado);
		} else {
			clienteRN.salvar(clienteSelecionado);
			FacesMessage faces = new FacesMessage(
					"Cliente cadastrado com sucesso!");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, faces);
		}
		this.lista = null;

	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getLista() {
		ClienteRN clienteRN = new ClienteRN();
		if (lista == null) {
			lista = clienteRN.listar();
		}
		return lista;
	}

	public void excluir() {
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.excluir(this.clienteSelecionado);
		this.lista = null;
	}

	public void novo() {
		this.clienteSelecionado = new Cliente();
	}
}
