package com.indracompany.stags.model;

public class Compra extends ModelAB {

	private TipoCompra tipoCompra;
	private ProdutoModel produto;

	public Compra(TipoCompra tipoCompra, ProdutoModel produto) {
		this.tipoCompra = tipoCompra;
		this.produto = produto;
	}

	public TipoCompra getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(TipoCompra tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

}