package com.indracompany.stags.model;

public class ClienteModel extends ModelAB{
	private String nome;
	private Integer idade;
	private String cpf;

	public ClienteModel(String nome, Integer idade, String cpf) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}
	
	public ClienteModel() {
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

//	Como adicionar o toString de ModelAB
	public String toString() {
		return "\n Nome: " + getNome() + "\n Idade: " + getIdade() + "\n CPF: " + getCpf();
	}
}
