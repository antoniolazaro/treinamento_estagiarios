package com.indracompany.stags.dao.memory;

import java.util.List;


import com.indracompany.stags.bo.MidiaBO;
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
		MidiaBO.validatePosicaoLista(posicaoLista);
		listar().set(posicaoLista, pModel);
	}

	@Override
	public void excluir(MidiaModel pModel) throws Exception {
		int posicaoLista = listar().indexOf(pModel);
		MidiaBO.validatePosicaoLista(posicaoLista);
		MidiaModel lModel = listar().get(posicaoLista);
		lModel.setAtivo(false);
	}

	@Override
	public List<MidiaModel> listar() throws Exception {
		return DataBase.getListaMidia();
	}

	@Override
	public MidiaModel buscar(MidiaModel pModel) throws Exception {
		MidiaModel lModel = null;		
		int posicaoLista = listar().indexOf(pModel);
		MidiaBO.validatePosicaoLista(posicaoLista);
		lModel = listar().get(posicaoLista);
		return lModel;		
	}
	
	public MidiaModel buscarMidia(String nome) throws Exception {
		try {
			for(MidiaModel midia  : listar()){
				if(midia.getNome().equalsIgnoreCase(nome)){
					System.out.println("Mídia encontrado: "+midia.toString());
					return midia;
				}
			}
			throw new Exception("Mídia não encontrada. ");
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}				
	}
	
	public MidiaModel buscar(Long codigo) throws Exception {
		try {
			for(MidiaModel midia  : listar()){
				if(midia.getCodigo().equals(codigo)){
					System.out.println("Mídia encontrada: "+midia.toString());
					return midia;
				}
			}
			throw new Exception("Mídia não encontrada. ");
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}
	}
}
