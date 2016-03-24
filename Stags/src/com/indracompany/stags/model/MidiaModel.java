package com.indracompany.stags.model;

public class MidiaModel extends ModelAB {
	private String descricao;
	private String codigoDeBarras;
	private String dataDeCompra;
	private String valorDeCompra;
	private String valorDeAluguel;
	private String valorDeVenda;
	
	public MidiaModel(String descricao, String codigoDeBarras, String dataDeCompra, String valorDeCompra,
			String valorDeAluguel, String valorDeVenda) {
		super();
		this.descricao = descricao;
		this.codigoDeBarras = codigoDeBarras;
		this.dataDeCompra = dataDeCompra;
		this.valorDeCompra = valorDeCompra;
		this.valorDeAluguel = valorDeAluguel;
		this.valorDeVenda = valorDeVenda;
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
	
	
	
	
	
}
