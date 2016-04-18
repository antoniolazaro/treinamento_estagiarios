package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.TransacaoModel;

public interface TransacaoBOIf {
	public void inserir(TransacaoModel pModel) throws Exception;
	
	public List<TransacaoModel> listar() throws Exception;
	
	public void validate(TransacaoModel pModel)throws Exception;

	public Double getValorTotal();

	public void setValorTotal(Double acumular);
}
