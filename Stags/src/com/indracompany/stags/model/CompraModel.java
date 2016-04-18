package com.indracompany.stags.model;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

public class CompraModel extends ModelAB {

	private TipoCompra tipoCompra;
	private List<ProdutoModel> produto =  new ArrayList<>();
	private ClienteModel clienteModel;
	private Date dataCompra = new Date();
	private Integer dias = 1;
	private Double valorTotal;

	public CompraModel() {
		
	}

	public CompraModel(TipoCompra tipoCompra, List<ProdutoModel> produto, ClienteModel clienteModel, Double valorTotal,
			Integer dias) {
		this.tipoCompra = tipoCompra;
		this.produto = produto;
		this.clienteModel = clienteModel;
		this.valorTotal = valorTotal;
		this.dias = dias;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ProdutoModel> getListaProduto() {
		return produto;
	}

	public void setListaProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

}