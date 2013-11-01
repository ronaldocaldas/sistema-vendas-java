package com.kurtphpr.sistema.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session sessao;

	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Produto produto) {
		this.sessao.save(produto);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		Criteria lista = sessao.createCriteria(Produto.class);

		return lista.list();
	}

	@Override
	public Produto pesquisarPorDescricao(String descricao) {
		String sql = "from Produto p where p.descricao like :descricao";
		Query consulta = sessao.createQuery(sql);
		consulta.setString("descricao", "%" + descricao + "%");
		return (Produto) consulta.uniqueResult();
	}

	@Override
	public void excluir(Produto produto) {
		this.sessao.delete(produto);

	}

}
