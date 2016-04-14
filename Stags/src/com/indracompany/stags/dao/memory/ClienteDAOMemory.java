package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.IClienteDAO;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ClienteModel;

public class ClienteDAOMemory implements IClienteDAO {

	@Override
	public void inserir(ClienteModel pModel) {
		pModel.setCodigo(DataBase.getCodigoCliente());
		DataBase.getListaCliente().add(pModel);
	}

	@Override
	public void editar(ClienteModel pModel) {

		int posicaoLista = DataBase.getListaCliente().indexOf(pModel);
		if (posicaoLista >= 0) {
			DataBase.getListaCliente().set(posicaoLista, pModel);
		}
	}

	@Override
	public void excluir(ClienteModel pModel) {

		DataBase.getListaCliente().set((int) pModel.getCodigo().longValue() - 1, pModel);

	}

	@Override
	public List<ClienteModel> listar() {
		return DataBase.getListaCliente();
	}

	@Override
	public ClienteModel buscar(String nome) {

		ClienteModel retorno = null;
		for (ClienteModel cliente : DataBase.getListaCliente()) {
			if (cliente.getNome().startsWith(nome)) {
				retorno = cliente;
			}
		}
		return retorno;
	}

}