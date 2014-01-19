package com.kurtphpr.sistema.venda;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.kurtphpr.sistema.cliente.Cliente;
import com.kurtphpr.sistema.cliente.ClienteRN;
import com.kurtphpr.sistema.produto.Produto;
import com.kurtphpr.sistema.produto.ProdutoRN;

@ManagedBean(name = "registroVendas")
@ViewScoped
public class RegistroVendaBean {

	private Cliente clienteSelecionado;
	private Produto produtoSelecionado = new Produto();
	private List<Produto> carrinhoCompras = new ArrayList<Produto>();
	private List<SelectItem> clienteSelect;
	private float valorTotal;

	public String buscarProduto() {

		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = new Produto();

		if (this.produtoSelecionado.getDescricao() != null
				&& !this.produtoSelecionado.getDescricao().equals("")) {
			produtoPesquisado = produtoRN
					.pesquisarPorNome(this.produtoSelecionado.getDescricao());

			if (produtoPesquisado != null) {

				this.carrinhoCompras.add(produtoPesquisado);
				calculaTotal();

			}

		}

		return null;
	}

	private void calculaTotal() {

		if (!this.carrinhoCompras.isEmpty()) {
			for (Produto p : this.carrinhoCompras) {
				valorTotal = +p.getValor();
			}
		}

	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getCarrinhoCompras() {
		return carrinhoCompras;
	}

	public void setCarrinhoCompras(List<Produto> carrinhoCompras) {
		this.carrinhoCompras = carrinhoCompras;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<SelectItem> getClienteSelect() {

		if (clienteSelect == null) {

			clienteSelect = new ArrayList<SelectItem>();
			ClienteRN clienteRN = new ClienteRN();
			List<Cliente> listaClientes = clienteRN.listar();

			if (listaClientes != null && !listaClientes.isEmpty()) {
				SelectItem item;
				for (Cliente clienteLista : listaClientes) {
					item = new SelectItem(clienteLista, clienteLista.getNome());
					clienteSelect.add(item);
				}
			}

		}

		return clienteSelect;
	}

	public void setClienteSelect(List<SelectItem> clienteSelect) {
		this.clienteSelect = clienteSelect;
	}

}
