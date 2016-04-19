package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public interface TransacaoBOIf {

	public void inserir(TransacaoModel pModel) throws Exception;
	
	public List<TransacaoModel> listar() throws Exception;
	
	public void validate(TransacaoModel pModel)throws Exception;

	public void getValorTotal(TransacaoModel pModel) throws Exception;

	public void setValorTotal(Double valorConta) throws Exception;

	public void diminuirQuantidade(MidiaModel lModel) throws Exception;

	public void incrementarValorTotalAluguel(MidiaModel lModel, TransacaoModel tModel) throws Exception;

	public void incrementarValorTotalVenda(MidiaModel lModel, TransacaoModel tModel) throws Exception;

	public void mostrarCompra(TransacaoModel pModel) throws Exception;
}
