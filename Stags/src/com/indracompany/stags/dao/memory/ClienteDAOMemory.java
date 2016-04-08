package com.indracompany.stags.dao.memory;

import java.util.Collection;
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
	
	public ClienteModel buscarCliente(ClienteModel pModel) throws Exception {
		try {
				ClienteModel retorno = null;
					for(ClienteModel cliente  : DataBase.getListaCliente()){
						if(cliente != null){
							if(cliente.getNome().equalsIgnoreCase(pModel.getNome())){
								retorno = cliente;
								System.out.println("Cliente encontrado: "+pModel.toString());
								break;
							}
						}				
					}
					return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar um cliente -> "+e.getMessage());
		}				
	}
	
	public static ClienteModel buscarCliente(String nome) throws Exception {
		try {
				ClienteModel retorno = null;
					for(ClienteModel cliente  : DataBase.getListaCliente()){
						if(cliente != null && nome != null){
							if(cliente.getNome().equalsIgnoreCase(cliente.getNome())){
								retorno = cliente;
								System.out.println("Cliente encontrado: "+cliente.toString());
								break;
							}
						}				
					}
					return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar um cliente -> "+e.getMessage());
		}				
	}
}
