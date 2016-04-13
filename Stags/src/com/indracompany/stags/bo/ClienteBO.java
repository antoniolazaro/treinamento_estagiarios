package com.indracompany.stags.bo;

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
	public void editar(String nomebusca , String nomeAtualizar) {
		ClienteModel buscaEditar = clienteDAO.buscar(nomebusca);
		buscaEditar.setNome(nomeAtualizar);
		clienteDAO.editar(buscaEditar);
	}

	@Override
	public void excluir(String nome) throws Exception {
		ClienteModel exclusao = clienteDAO.buscar(nome);
		exclusao.setAtivo(false);
		clienteDAO.excluir(exclusao);
	}

	@Override
	public List<ClienteModel> listar() throws Exception {
		return clienteDAO.listar();
	}

	@Override
	public ClienteModel buscar(String nome) throws Exception {
		return clienteDAO.buscar(nome);
	}

	private void validate(ClienteModel pModel) throws Exception {
		if (pModel != null) {
			if (pModel.getNome() == null || pModel.getNome().equals("")) {
				throw new Exception("Nome é um campo obrigatório");
			}
		}
	}

}
