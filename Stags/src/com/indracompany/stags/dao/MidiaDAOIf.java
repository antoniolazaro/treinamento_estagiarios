package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.MidiaModel;

public interface MidiaDAOIf {
	
	public void inserir(MidiaModel pModel) throws Exception;
	
	public void editar(MidiaModel pModel) throws Exception;
	
	public void excluir(MidiaModel pModel) throws Exception;
	
	public List<MidiaModel> listar() throws Exception;
	
	public MidiaModel buscar(MidiaModel pModel) throws Exception;

	public MidiaModel buscarMidia(String nome) throws Exception;
	
	public MidiaModel buscar(Long codigo) throws Exception;
}
