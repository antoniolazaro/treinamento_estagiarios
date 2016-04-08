package com.indracompany.stags.model;

import java.util.Date;
import java.util.List;

public class CompraModel extends ModelAB {

	private TipoCompra tipoCompra;
	private List<ProdutoModel> produto;
	private ClienteModel clienteModel;
	private Date dataCompra;

	public CompraModel() {

	}

	public CompraModel(TipoCompra tipoCompra, List<ProdutoModel> produto, ClienteModel clienteModel, Date dataCompra) {
		this.tipoCompra = tipoCompra;
		this.produto = produto;
		this.clienteModel = clienteModel;
		this.dataCompra = dataCompra;
	}

	public TipoCompra getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(TipoCompra tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public Date getDataCompra() {
		return new Date();
	}

	public List<ProdutoModel> getListaProduto() {
		return produto;
	}

	public void setListaProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

}