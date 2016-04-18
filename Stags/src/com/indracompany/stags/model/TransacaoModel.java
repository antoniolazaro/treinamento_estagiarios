package com.indracompany.stags.model;
import java.util.ArrayList;
import java.util.List;

public class TransacaoModel extends ModelAB {
	public List<MidiaModel> listaMidia;
	private ClienteModel cliente;
	private String dataRegistro;
	private Double valorTotal;
	
	public TransacaoModel(List<MidiaModel> listaMidia, ClienteModel cliente, String dataRegistro, Double valorTotal) {
		super();
		this.listaMidia = new ArrayList<MidiaModel>();
		this.cliente = cliente;
		this.dataRegistro = dataRegistro;
		this.valorTotal = valorTotal;
	}
	
	public TransacaoModel() {
		
	}
	
	public List<MidiaModel> getListaMidia() {
		return listaMidia;
	}
	public void setListaMidia(List<MidiaModel> listaMidia) {
		this.listaMidia = listaMidia;
	}
	public void addMidia(MidiaModel pModel) {
		this.listaMidia.add(pModel);
	}
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Override
	public String toString() {
		return "*******************************************************" + "\nCliente" + getCliente() + "\nLista de mídias:\n" + getListaMidia() + "\nData da transação: " + getDataRegistro()
				+ "\nValor total=" + getValorTotal() + "\n";
	}	
}
