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
		try {
			midiaDAO.inserir(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar adicionar uma mídia -> "+e.getMessage());
		}
	}

	@Override
	public void editar(MidiaModel pModel) throws Exception {
		validate(pModel);
		try {
			midiaDAO.editar(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar editar uma mídia -> "+e.getMessage());
		}
	}

	@Override
	public void excluir(MidiaModel pModel) throws Exception {
		try {
			midiaDAO.excluir(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar adicionar uma mídia -> "+e.getMessage());
		}
	}

	@Override
	public List<MidiaModel> listar() throws Exception {
		try {
			return midiaDAO.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao tentar listar mídia -> "+e.getMessage());
		}
	}

	@Override
	public MidiaModel buscar(MidiaModel pModel) throws Exception {
		try {
			return midiaDAO.buscar(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar uma mídia -> "+e.getMessage());
		}
	}

	private void validate(MidiaModel pModel)throws Exception {
		try {
			if(pModel != null){
				if(pModel.getNome() == null || pModel.getNome().equals("")){
					throw new Exception("Nome é um campo obrigatório");
				}
			}
		} catch (Exception e) {
			throw new Exception("Erro ao tentar validar uma mídia -> "+e.getMessage());
		}
	}

	@Override
	public MidiaModel buscarMidia(String nome) throws Exception {
		try {
			return midiaDAO.buscarMidia(nome);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar uma mídia pelo nome -> "+e.getMessage());
		}
		}
}
