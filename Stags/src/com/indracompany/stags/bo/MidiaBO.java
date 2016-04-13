package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.dao.MidiaDAOIf;
import com.indracompany.stags.dao.memory.MidiaDAOMemory;
import com.indracompany.stags.model.MidiaModel;

public class MidiaBO implements MidiaBOIf{
	private MidiaDAOIf midiaDAO; 
	
	public MidiaBO(){
		midiaDAO = new MidiaDAOMemory();
	}

	@Override
	public void inserir(MidiaModel pModel) throws Exception {
		validate(pModel);
		midiaDAO.inserir(pModel);		
	}

	@Override
	public void editar(MidiaModel pModel) throws Exception {
		validate(pModel);
		midiaDAO.editar(pModel);		
	}

	@Override
	public void excluir(MidiaModel pModel) throws Exception {
		midiaDAO.excluir(pModel);		
	}

	@Override
	public List<MidiaModel> listar() throws Exception {		
		return midiaDAO.listar();
	}

	@Override
	public MidiaModel buscar(MidiaModel pModel) throws Exception {		
		return midiaDAO.buscar(pModel);
	}

	private void validate(MidiaModel pModel)throws Exception {	
		if(pModel != null){
			if(pModel.getNome() == null || pModel.getNome() .equals("")){
				throw new Exception("Nome é um campo obrigatório");
			}
		}
	}

	@Override
	public MidiaModel buscarMidia(String nome) throws Exception {
		return midiaDAO.buscarMidia(nome);
	}	
}
