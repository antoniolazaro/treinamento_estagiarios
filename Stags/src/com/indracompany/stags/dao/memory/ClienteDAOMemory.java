package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.dao.ClienteDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ClienteModel;

public class ClienteDAOMemory implements ClienteDAOIf {

	@Override
	public void inserir(ClienteModel pModel) throws Exception {
		pModel.setCodigo(DataBase.getCodigoCliente());
		listar().add(pModel);
	}

	@Override
	public void editar(ClienteModel pModel) throws Exception {		
		int posicaoLista = listar().indexOf(pModel);
		ClienteBO.validatePosicaoLista(posicaoLista);
		listar().set(posicaoLista, pModel);
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		int posicaoLista = listar().indexOf(pModel);
		ClienteBO.validatePosicaoLista(posicaoLista);
		ClienteModel lModel = listar().get(posicaoLista);
		lModel.setAtivo(false);
	}

	@Override
	public List<ClienteModel> listar() throws Exception {
		return DataBase.getListaCliente();
	}

	@Override
	public ClienteModel buscar(ClienteModel pModel) throws Exception {
		ClienteModel lModel = null;		
		int posicaoLista = listar().indexOf(pModel);	
		ClienteBO.validatePosicaoLista(posicaoLista);
		lModel = listar().get(posicaoLista);
		return lModel;		
	}
	
	public ClienteModel buscarCliente(String nome) throws Exception {
		try{
			for(ClienteModel cliente  : listar()){
				if(cliente.getNome().equalsIgnoreCase(nome)){
					System.out.println("Cliente encontrado: "+cliente.toString());
					return cliente;
				}
			}
			throw new Exception("Cliente não encontrado. ");
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}
	}
	}