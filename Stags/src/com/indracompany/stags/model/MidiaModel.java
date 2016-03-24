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
	
	
	
	
	
}
