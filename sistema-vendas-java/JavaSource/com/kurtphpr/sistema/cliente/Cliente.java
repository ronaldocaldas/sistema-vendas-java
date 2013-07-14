package com.kurtphpr.sistema.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Integer id;
	private String cpf;
	private String email;
	private String endereco;
	private String nome;
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	private float renda;

	
	public Cliente(){
		
	}
	
	public Cliente(String cpf, String email, String endereco, String nome,
			Date dataCadastro, float renda) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.renda = renda;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public float getRenda() {
		return renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

}
