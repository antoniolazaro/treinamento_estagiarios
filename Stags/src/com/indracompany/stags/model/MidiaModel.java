package com.indracompany.stags.model;

public class MidiaModel extends ModelAB {
	private String nome;
	private String descricao;
	private String codigoDeBarras;
	private String dataDeCompra;
	private String valorDeCompra;
	private String valorDeAluguel;
	private String valorDeVenda;
	private TipoDeMidia tipoDeMidia;

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

	public TipoDeMidia getTipoDeMidia() {
		return tipoDeMidia;
	}

	public void setTipoDeMidia(TipoDeMidia tipoDeMidia) {
		this.tipoDeMidia = tipoDeMidia;
	}

	@Override
	public String toString() {
		return "MidiaModel [Nome: " + getNome() + "\n Descrição: " + getDescricao() + "\n Codigo de Barras: " + getCodigoDeBarras()
				+ "\n Data de Compra: " + getDataDeCompra() + "\n Valor de Compra: " + getValorDeCompra() + "\n Valor de Aluguel: "
				+ getValorDeAluguel() + "\n Valor de Venda: " + getValorDeVenda() + "\n Tipo de mídia: " + getTipoDeMidia() + "]";
	}
}
