package com.kurtphpr.sistema.venda;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kurtphpr.sistema.produto.Produto;

public class VendaDAOHibernate implements VendaDAO {
	private Session sessao;

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void registra(Venda venda) {
		this.sessao.save(venda);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venda> getLista() {
		Criteria lista = sessao.createCriteria(Venda.class);
		return lista.list();
	}

	@Override
	public void excluir(Venda venda) {
		this.sessao.delete(venda);
	}

	@Override
	public boolean existeEstoqueProduto(Produto produto) {

		Produto produtoPesquisado = (Produto) this.sessao.get(Produto.class,
				produto.getId());

		if (produtoPesquisado != null) {
			if (produtoPesquisado.getEstoque() > 0) {
				return true;
			}
		}

		return false;

	}

	@Override
	public void reduzEstoqueProduto(Produto produto) {
		String hql = "update Produto p set p.estoque =:novoEstoque where p.id =:idProduto";
		Query query = sessao.createQuery(hql);
		query.setInteger("novoEstoque", produto.getEstoque() - 1);
		query.setLong("idProduto", produto.getId());
		query.executeUpdate();

	}

}
