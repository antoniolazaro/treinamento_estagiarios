package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public interface TransacaoDAOIf {
	public void inserir(TransacaoModel pModel) throws Exception;
	
	public List<TransacaoModel> listar() throws Exception;

	public List<TransacaoModel> getValorTotal(TransacaoModel tModel) throws Exception;

	public void incrementarValorTotal(Double pModel) throws Exception;

	public void setValorTotal(Double mModel) throws Exception;

	public void exibirHistoricoAluguelCliente(ClienteModel pModel) throws Exception;

	public void exibirHistoricoAluguelMidia(MidiaModel pModel) throws Exception;

//	public void addMidia(MidiaModel pModel, TransacaoModel tModel) throws Exception;
}
