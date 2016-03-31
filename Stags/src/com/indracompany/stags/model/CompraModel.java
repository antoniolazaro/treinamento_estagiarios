package com.indracompany.stags.model;
import java.util.ArrayList;
import java.util.List;

public class CompraModel {
	public List<String> midia;
	private ClienteModel cliente;
	
	public CompraModel(List<String> midia, ClienteModel cliente) {
		super();
		this.midia = midia;
		this.cliente = cliente;
	}

	public List<String> getMidia() {
		return midia;
	}

	public void setMidia(List<String> midia) {
		this.midia = midia;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	
}
