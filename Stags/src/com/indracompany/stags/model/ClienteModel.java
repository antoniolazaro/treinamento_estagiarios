package com.indracompany.stags.model;

import java.util.Collection;

import com.indracompany.stags.dao.util.DataBase;

public class ClienteModel extends ModelAB{
	private String nome;
	private String idade;
	private String cpf;

	public ClienteModel(String nome, String idade, String cpf) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n Nome: " + getNome() + "\n C�digo: " + getCodigo() +  "\n Idade: " + getIdade() + "\n CPF: " + getCpf() + "\n Est� ativo? " + getAtivo() + "\n";
	}

	public ClienteModel getNomeBusca(String busca) {
		ClienteModel retorno = null;
		if(nome != null && cpf != null && idade != null && DataBase.getListaCliente().size() > 0 ){
			Collection<ClienteModel> listaCliente = (DataBase.getListaCliente()).values();
			for(ClienteModel cliente  : DataBase.getListaCliente()){
				if(cliente != null){
					if(nome.equalsIgnoreCase(cliente.getNome())){
						retorno = cliente;
						break;
					} else {
						System.out.println("Registro n�o encontrado.");
					}
				}				
			}
		}
		return retorno;
	}	
}
