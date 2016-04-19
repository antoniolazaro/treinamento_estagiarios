package com.indracompany.stags.model;
import java.util.ArrayList;
import java.util.List;

public class TransacaoModel extends ModelAB {
	public List<MidiaModel> listaMidia;
	private ClienteModel cliente;
	private String dataRegistro;
	private Double valorTotal;
	
	public TransacaoModel(List<MidiaModel> listaMidia, ClienteModel cliente, String dataRegistro, Double valorTotal) {		
		this();
		this.cliente = cliente;
		this.dataRegistro = dataRegistro;
		this.valorTotal = valorTotal;
	}
	
	public TransacaoModel() {
		super();
		this.listaMidia = new ArrayList<MidiaModel>();
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
		StringBuilder buffer = new StringBuilder();
		buffer.append("*******************************************************").append("\nCliente: ").append(getCliente()).append("\nLista de mídias:\n").append(getListaMidia()).append("\nValor total: ").append(getValorTotal()).append("\nData da transação: ").append(getDataRegistro()).append("\nCódigo: ").append(getCodigo()).append("\nEstá ativo? ");
		if(getAtivo() != null && getAtivo()){
			buffer.append(" Ativo.");
		}else{
			buffer.append(" Inativo.");
		}
		return  buffer.toString();		
	}	
}
