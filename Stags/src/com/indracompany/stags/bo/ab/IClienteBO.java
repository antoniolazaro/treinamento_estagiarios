package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.ClienteModel;

public interface IClienteBO {
	public void inserir(ClienteModel pModel) throws Exception;

	public void editar(ClienteModel pModel) throws Exception;

	public void excluir(ClienteModel pModel) throws Exception;

	public List<ClienteModel> listar() throws Exception;

	public ClienteModel buscar(String nome) throws Exception;

	public void tratarSituacaoCliente(ClienteModel cliente);

}