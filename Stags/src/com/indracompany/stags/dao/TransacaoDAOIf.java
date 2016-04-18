package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.TransacaoModel;

public interface TransacaoDAOIf {
	public void inserir(TransacaoModel pModel) throws Exception;
	
	public List<TransacaoModel> listar() throws Exception;
}
