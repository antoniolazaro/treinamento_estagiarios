package com.indracompany.stags.model;

import java.util.Collection;

import com.indracompany.stags.dao.util.DataBase;

public class MidiaModel extends ModelAB {
	private String nome;
	private String descricao;
	private String codigoDeBarras;
	private String dataDeCompra;
	private String valorDeCompra;
	private String valorDeAluguel;
	private String valorDeVenda;
	private TipoDeMidiaModel tipoDeMidia;

	public MidiaModel(String nome, String descricao, String codigoDeBarras, String dataDeCompra, String valorDeCompra,
			String valorDeAluguel, String valorDeVenda) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.codigoDeBarras = codigoDeBarras;
		this.dataDeCompra = dataDeCompra;
		this.valorDeCompra = valorDeCompra;
		this.valorDeAluguel = valorDeAluguel;
		this.valorDeVenda = valorDeVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getDataDeCompra() {
		return dataDeCompra;
	}

	public void setDataDeCompra(String dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}

	public String getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(String valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public String getValorDeAluguel() {
		return valorDeAluguel;
	}

	public void setValorDeAluguel(String valorDeAluguel) {
		this.valorDeAluguel = valorDeAluguel;
	}

	public String getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(String valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public TipoDeMidiaModel getTipoDeMidia() {
		return tipoDeMidia;
	}

	public void setTipoDeMidia(TipoDeMidiaModel tipoDeMidia) {
		this.tipoDeMidia = tipoDeMidia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoDeBarras == null) ? 0 : codigoDeBarras.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoDeMidia == null) ? 0 : tipoDeMidia.hashCode());
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
		MidiaModel other = (MidiaModel) obj;
		if (codigoDeBarras == null) {
			if (other.codigoDeBarras != null)
				return false;
		} else if (!codigoDeBarras.equals(other.codigoDeBarras))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoDeMidia != other.tipoDeMidia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n Nome: " + getNome() + "\n Descrição: " + getDescricao() + "\n Codigo de Barras: " + getCodigoDeBarras()
				+ "\n Data de Compra: " + getDataDeCompra() + "\n Valor de Compra: " + getValorDeCompra() + "\n Valor de Aluguel: "
				+ getValorDeAluguel() + "\n Valor de Venda: " + getValorDeVenda() + "\n Tipo de mídia: " + getTipoDeMidia();
	}

	public MidiaModel getNomeBusca(String busca) {
		MidiaModel retorno = null;
		if(nome != null && codigoDeBarras != null && tipoDeMidia != null && DataBase.getListaMidia().size() > 0 ){
			Collection<MidiaModel> listaMidia = (DataBase.getListaMidia()).values();
			for(MidiaModel midia  : DataBase.getListaMidia()){
				if(midia != null){
					if(nome.equalsIgnoreCase(midia.getNome())){
						retorno = midia;
						break;
					} else {
						System.out.println("Registro não encontrado.");
					}
				}				
			}
		}
		return retorno;
	}	
}
