package com.indracompany.stags.dao.memory;

import java.util.List;
import com.indracompany.stags.dao.MidiaDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.MidiaModel;

public class MidiaDAOMemory implements MidiaDAOIf {
	@Override
	public void inserir(MidiaModel pModel) throws Exception {
		pModel.setCodigo(DataBase.getCodigoMidia());
		listar().add(pModel);
	}

	@Override
	public void editar(MidiaModel pModel) throws Exception {
		
		int posicaoLista = listar().indexOf(pModel);	
		if(posicaoLista >= 0){
			listar().set(posicaoLista, pModel);
		} else {
			throw new Exception("Erro ao tentar editar uma mídia");
		}
	}

	@Override
	public void excluir(MidiaModel pModel) throws Exception {
		int posicaoLista = listar().indexOf(pModel);	
		if(posicaoLista >= 0){
			MidiaModel lModel = listar().get(posicaoLista);
			lModel.setAtivo(false);
		}	
	}

	@Override
	public List<MidiaModel> listar() throws Exception {
		return DataBase.getListaMidia();
	}

	@Override
	public MidiaModel buscar(MidiaModel pModel) throws Exception {
		MidiaModel lModel = null;		
		int posicaoLista = listar().indexOf(pModel);	
		if(posicaoLista >= 0){
			lModel = listar().get(posicaoLista);
		} else {
			throw new Exception("Erro ao buscar uma mídia");
		}
		return lModel;		
	}
	
	public MidiaModel buscarMidia(String nome) throws Exception {
		try {
			MidiaModel retorno = null;
					for(MidiaModel midia  : listar()){
							if(midia.getNome().equalsIgnoreCase(nome)){
								retorno = midia;
								System.out.println("Mídia encontrado: "+midia.toString());
								break;
							}		
					}
					return retorno;
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar uma mídia -> "+e.getMessage());
		}				
	}
}
