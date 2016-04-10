package com.indracompany.stags.dao.memory;

import java.util.List;
import com.indracompany.stags.dao.MidiaDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.MidiaModel;

public class MidiaDAOMemory implements MidiaDAOIf {
	@Override
	public void inserir(MidiaModel pModel) throws Exception {
		pModel.setCodigo(DataBase.getCodigoMidia());
		DataBase.getListaMidia().add(pModel);		
	}

	@Override
	public void editar(MidiaModel pModel) throws Exception {
		
		int posicaoLista = DataBase.getListaMidia().indexOf(pModel);	
		if(posicaoLista >= 0){
			 DataBase.getListaMidia().set(posicaoLista, pModel);
		}
	}

	@Override
	public void excluir(MidiaModel pModel) throws Exception {
		int posicaoLista = DataBase.getListaMidia().indexOf(pModel);	
		if(posicaoLista >= 0){
			MidiaModel lModel = DataBase.getListaMidia().get(posicaoLista);
			if(lModel != null){
				lModel.setAtivo(false);
			}
		}	
	}

	@Override
	public List<MidiaModel> listar() throws Exception {
		return DataBase.getListaMidia();
	}

	@Override
	public MidiaModel buscar(MidiaModel pModel) throws Exception {
		MidiaModel lModel = null;		
		int posicaoLista = DataBase.getListaMidia().indexOf(pModel);	
		if(posicaoLista >= 0){
			lModel = DataBase.getListaMidia().get(posicaoLista);
		}			
		return lModel;		
	}

	public MidiaModel buscarMidia(MidiaModel pModel) throws Exception {
		try {
			MidiaModel retorno = null;
					for(MidiaModel midia  : DataBase.getListaMidia()){
						if(midia != null){
							if(midia.getNome().equalsIgnoreCase(pModel.getNome())){
								retorno = midia;
								System.out.println("Mídia encontrada: "+pModel.toString());
								break;
							}
						}				
					}
					return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar uma mídia -> "+e.getMessage());
		}				
	}
	
	public static MidiaModel buscarMidia(String nome) throws Exception {
		try {
			MidiaModel retorno = null;
					for(MidiaModel midia  : DataBase.getListaMidia()){
						if(midia != null && nome != null){
							if(midia.getNome().equalsIgnoreCase(midia.getNome())){
								retorno = midia;
								System.out.println("Mídia encontrado: "+midia.toString());
								break;
							}
						}				
					}
					return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar uma mídia -> "+e.getMessage());
		}				
	}
}
