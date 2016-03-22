package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ClienteDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ClienteModel;

public class ClienteDAOMemory implements ClienteDAOIf {

	@Override
	public void inserir(ClienteModel pModel) throws Exception {
		pModel.setCodigo(DataBase.getCodigoCliente());
		DataBase.getListaCliente().add(pModel);		
	}

	@Override
	public void editar(ClienteModel pModel) throws Exception {
		
		int posicaoLista = DataBase.getListaCliente().indexOf(pModel);	
		if(posicaoLista >= 0){
			 DataBase.getListaCliente().set(posicaoLista, pModel);
		}
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		int posicaoLista = DataBase.getListaCliente().indexOf(pModel);	
		if(posicaoLista >= 0){
			ClienteModel lModel = DataBase.getListaCliente().get(posicaoLista);
			if(lModel != null){
				lModel.setAtivo(false);
			}
		}	
	}

	@Override
	public List<ClienteModel> listar() throws Exception {
		return DataBase.getListaCliente();
	}

	@Override
	public ClienteModel buscar(ClienteModel pModel) throws Exception {
		ClienteModel lModel = null;		
		int posicaoLista = DataBase.getListaCliente().indexOf(pModel);	
		if(posicaoLista >= 0){
			lModel = DataBase.getListaCliente().get(posicaoLista);
		}			
		return lModel;		
	}

	

}
