package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.TransacaoModel;

public interface TransacaoDAOIf {
	public void inserir(TransacaoModel pModel) throws Exception;
	
	public List<TransacaoModel> listar() throws Exception;

	public List<TransacaoModel> getValorTotal(TransacaoModel tModel) throws Exception;

	public void incrementarValorTotal(Double pModel) throws Exception;

	public void setValorTotal(Double mModel) throws Exception;
}
