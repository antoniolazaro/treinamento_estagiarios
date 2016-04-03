package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.ClienteModel;

public interface IClienteDAO {
	
	public void inserir(ClienteModel pModel) throws Exception;
	
	public void editar(ClienteModel pModel) throws Exception;
	
	public void excluir(ClienteModel pModel) throws Exception;
	
	public List<ClienteModel> listar() throws Exception;
	
	public ClienteModel buscar(ClienteModel pModel) throws Exception;
}
