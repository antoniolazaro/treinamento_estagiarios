package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.ClienteModel;

public interface IClienteDAO {

	public void inserir(ClienteModel pModel);

	public void editar(ClienteModel pModel);

	public void excluir(ClienteModel pModel);

	public List<ClienteModel> listar();

	public ClienteModel buscar(String nome);
}
