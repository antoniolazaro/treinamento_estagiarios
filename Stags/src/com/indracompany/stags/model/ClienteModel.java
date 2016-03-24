package com.indracompany.stags.model;

public class ClienteModel extends ModelAB{
	private String nome;
	private String codigo;
	private String idade;
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return super.toString() + ", nome=" + nome;
	}
	
	
}
