package com.indracompany.stags.bo;

import java.util.Collection;
import java.util.List;

import com.indracompany.stags.bo.ab.IClienteBO;
import com.indracompany.stags.dao.IClienteDAO;
import com.indracompany.stags.dao.memory.ClienteDAOMemory;
import com.indracompany.stags.model.ClienteModel;

public class ClienteBO implements IClienteBO {
	private IClienteDAO clienteDAO;

	public ClienteBO() {
		clienteDAO = new ClienteDAOMemory();
	}

	@Override
	public void inserir(ClienteModel pModel) throws Exception {

		validate(pModel);
		clienteDAO.inserir(pModel);
	}

	@Override
	public void editar(ClienteModel pModel) {
		clienteDAO.editar(pModel);
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		pModel.setAtivo(false);
		clienteDAO.excluir(pModel);
	}

	@Override
	public List<ClienteModel> listar() throws Exception {

		validateList(clienteDAO.listar());
		return clienteDAO.listar();
	}

	@Override
	public ClienteModel buscar(String nome) throws Exception {
		if (nome == null || nome.equals("")) {
			throw new Exception("Nome Obrigatório");
		}

		validateBusca(clienteDAO.buscar(nome));
		return clienteDAO.buscar(nome);
	}

	private void validate(ClienteModel pModel) throws Exception {
		if (pModel != null) {
			if (pModel.getNome() == null || pModel.getNome().equals("")) {
				throw new Exception("Nome é um campo obrigatório");
			}
		}
	}

	private void validateList(Collection<ClienteModel> lista) throws Exception {
		if (lista == null) {
			throw new Exception("Lista Vazia");
		}
	}

	private void validateBusca(ClienteModel cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("Cliente  Não Existe!");
		}
	}

	@Override
	public void tratarSituacaoCliente(ClienteModel cliente) {
		if (cliente.getAtivo() == true) {
			System.out.println("Situação: Ativo");
		} else {
			System.out.println("Situação: inativo");
		}
	}
}