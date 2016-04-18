package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.TransacaoDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.TransacaoModel;

public class TransacaoDAOMemory implements TransacaoDAOIf {
	@Override
	public void inserir(TransacaoModel pModel) throws Exception {
		pModel.setCodigo(DataBase.getCodigoTransacao());
		DataBase.getListaTransacao().add(pModel);
	}
	
	public List<TransacaoModel> listar() throws Exception {
		return DataBase.getListaTransacao();
	}
}
