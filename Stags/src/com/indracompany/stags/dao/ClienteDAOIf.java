package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.ClienteModel;

public interface ClienteDAOIf {
	
	public void inserir(ClienteModel pModel) throws Exception;
	
	public void editar(ClienteModel pModel) throws Exception;
	
	public void excluir(ClienteModel pModel) throws Exception;
	
	public List<ClienteModel> listar() throws Exception;
	
	public ClienteModel buscar(ClienteModel pModel) throws Exception;

	public ClienteModel buscarCliente(String nome)  throws Exception;

	public String exibirHistoricoAluguelCliente(ClienteModel pModel) throws Exception;
}
