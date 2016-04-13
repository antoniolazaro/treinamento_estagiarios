package com.indracompany.stags.model;
import java.util.Date;
import java.util.List;

public class TransacaoModel {
	public List<MidiaModel> listaMidia;
	private ClienteModel cliente;
	private Date dataCompra;
	private Double valorTotal;
	
	public List<MidiaModel> getListaMidia() {
		return listaMidia;
	}
	public void setListaMidia(List<MidiaModel> listaMidia) {
		this.listaMidia = listaMidia;
	}
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
