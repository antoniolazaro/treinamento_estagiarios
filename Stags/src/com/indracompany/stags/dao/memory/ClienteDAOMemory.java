package com.indracompany.stags.dao.memory;

import java.util.List;

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
		if(posicaoLista >= 0){
			listar().set(posicaoLista, pModel);
		}else{
			throw new Exception("Erro ao tentar editar um cliente");
		}
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		int posicaoLista = listar().indexOf(pModel);	
		if(posicaoLista >= 0){
			ClienteModel lModel = listar().get(posicaoLista);
			if(lModel != null){
				lModel.setAtivo(false);
			}else{
				throw new Exception("Erro ao tentar excluir um cliente");
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
		int posicaoLista = listar().indexOf(pModel);	
		if(posicaoLista >= 0){
			lModel = listar().get(posicaoLista);
		}else{
			throw new Exception("Erro ao tentar buscar um cliente");
		}		
		return lModel;		
	}
	
	public ClienteModel buscarCliente(ClienteModel pModel) throws Exception {
		try {
				ClienteModel retorno = null;
					for(ClienteModel cliente  : listar()){
						if(cliente != null){
							if(cliente.getNome().equalsIgnoreCase(pModel.getNome())){
								retorno = cliente;
								System.out.println("Cliente encontrado: "+pModel.toString());
								break;
							}						
						}else{
							throw new Exception("Erro ao tentar buscar um cliente");
						}
					}
					return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar um cliente -> "+e.getMessage());
		}				
	}
	
	
	// não tá funcionando o método.  Não tá encontrando!
	public ClienteModel buscarCliente(String nome) throws Exception {		
			ClienteModel retorno = null;
			for(ClienteModel cliente  : listar()){
					if(cliente.getNome().equalsIgnoreCase(nome)) {
//					if (cliente.getNome().startsWith(nome)) {
						retorno = cliente;
						return retorno;
				}else{
					throw new Exception("Erro ao tentar buscar um cliente");
				}
			}
				return retorno;
			}
	}
//		
//				ClienteModel lModel = null;				
//				int posicaoLista = DataBase.getListaCliente().indexOf(nome);	
//				if(posicaoLista >= 0) {
//					lModel = DataBase.getListaCliente().get(posicaoLista);
//					System.out.println("Cliente encontrado: "+lModel.toString());					
//				}
//				return lModel;
//		} catch (Exception e) {
//			throw new Exception("Erro ao tentar buscar um cliente -> "+e.getMessage());
//		}				
//	}