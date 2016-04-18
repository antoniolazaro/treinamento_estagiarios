package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.TransacaoDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.TransacaoModel;

public class TransacaoDAOMemory implements TransacaoDAOIf {
	@Override
	public void inserir(TransacaoModel tModel) throws Exception {
		tModel.setCodigo(DataBase.getCodigoTransacao());
		DataBase.getListaTransacao().add(tModel);
	}
	
	public List<TransacaoModel> listar() throws Exception {
		return DataBase.getListaTransacao();
	}

	public Double setValorTotal(Double pModel) throws Exception {
		TransacaoModel tModel = new TransacaoModel();
		return tModel.setValorTotal(DataBase.getValorTotal(0.001) + pModel);
	}

	public List<TransacaoModel> getValorTotal(TransacaoModel tModel) throws Exception {
		return DataBase.getListaTransacao();
	}
}
