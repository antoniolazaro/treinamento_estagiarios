package com.indracompany.stags.model;

public class ClienteModel extends ModelAB{
	private String nome;
	private String codigo;
	private String idade;
	private String cpf;

	public ClienteModel(String nome, String codigo, String idade, String cpf) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.idade = idade;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return super.toString() + ", nome=" + nome;
	}
	
	
}
