package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.IClienteBO;
import com.indracompany.stags.dao.ClienteDAOIf;
import com.indracompany.stags.dao.memory.ClienteDAOMemory;
import com.indracompany.stags.model.ClienteModel;

public class ClienteBO implements IClienteBO{
	private ClienteDAOIf clienteDAO;
	
	public ClienteBO(){
		clienteDAO = new ClienteDAOMemory();
	}

	@Override
	public void inserir(ClienteModel pModel) throws Exception {
		validate(pModel);
		clienteDAO.inserir(pModel);		
	}

	@Override
	public void editar(ClienteModel pModel) throws Exception {
		validate(pModel);
		clienteDAO.editar(pModel);		
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		clienteDAO.excluir(pModel);		
	}

	@Override
	public List<ClienteModel> listar() throws Exception {		
		return clienteDAO.listar();
	}

	@Override
	public ClienteModel buscar(ClienteModel pModel) throws Exception {		
		return clienteDAO.buscar(pModel);
	}

	private void validate(ClienteModel pModel)throws Exception {	
		if(pModel != null){
			if(pModel.getNome() == null || pModel.getNome() .equals("")){
				throw new Exception("Nome é um campo obrigatório");
			}
		}
	}
	
	
}
