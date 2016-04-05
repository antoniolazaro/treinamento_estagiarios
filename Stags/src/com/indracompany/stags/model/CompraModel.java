package com.indracompany.stags.model;

public class CompraModel extends ModelAB {

	private TipoCompra tipoCompra;
	private ProdutoModel produto;
	private ClienteModel clienteModel;

	public CompraModel(TipoCompra tipoCompra, ProdutoModel produto, ClienteModel clienteModel) {
		this.tipoCompra = tipoCompra;
		this.produto = produto;
		this.setClienteModel(clienteModel);
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

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

}