package com.indracompany.stags.model;

import java.util.Date;

public class MidiaModel extends ModelAB {
	private String nome;
	private String descricao;
	private String codigoBarras;
	private Date dataRegistro;
	private Double valorAluguel;
	private Double valorVenda;
	private TipoDeMidiaModel tipoMidia;
	private Integer quantidadeEstoque;
	
	public MidiaModel(String nome, String descricao, String codigoBarras, Date dataRegistro, Double valorAluguel,
			Double valorVenda, TipoDeMidiaModel tipoMidia, Integer quantidadeEstoque) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;
		this.dataRegistro = dataRegistro;
		this.valorAluguel = valorAluguel;
		this.valorVenda = valorVenda;
		this.tipoMidia = tipoMidia;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public MidiaModel() {
		
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

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public TipoDeMidiaModel getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoDeMidiaModel tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoMidia == null) ? 0 : tipoMidia.hashCode());
		result = prime * result + ((valorAluguel == null) ? 0 : valorAluguel.hashCode());
		result = prime * result + ((valorVenda == null) ? 0 : valorVenda.hashCode());
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
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
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
		return "\n Nome: " + getNome() + "\n Descrição: " + getDescricao() + "\n Codigo de Barras: " + getCodigoBarras()
				+ "\n Data de Entrada no sistema: " + getDataRegistro() + "\n Valor de Compra: " + getValorVenda() + "\n Valor de Aluguel: "
				+ getValorAluguel() + "\n Valor de Venda: " + getValorVenda() + "\n Tipo de mídia: " + getTipoMidia() + "\n Quantidade no estoque: " + getQuantidadeEstoque();
	}
}
