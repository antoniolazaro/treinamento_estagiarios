package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.TransacaoDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public class TransacaoDAOMemory implements TransacaoDAOIf {
	@Override
	public void inserir(TransacaoModel tModel) throws Exception {
		tModel.setCodigo(DataBase.getCodigoTransacao());
		DataBase.getListaTransacao().add(tModel);
	}

	@Override
	public List<TransacaoModel> listar() throws Exception {
		return DataBase.getListaTransacao();
	}	

	@Override
	public List<TransacaoModel> getValorTotal(TransacaoModel tModel) throws Exception {
		return DataBase.getListaTransacao();
	}

	@Override
	public void incrementarValorTotal(Double pModel) throws Exception {
		DataBase.getListaTransacao();		
	}

	@Override
	public void setValorTotal(Double mModel) throws Exception {
		DataBase.getListaTransacao();
	}
	
	@Override
	public void exibirHistoricoAluguelCliente(ClienteModel pModel) throws Exception {		
		DataBase.getListaTransacao();		
	}

	@Override
	public void exibirHistoricoAluguelMidia(MidiaModel pModel) throws Exception {
		DataBase.getListaTransacao();		
	}

//	@Override
//	public void addMidia(MidiaModel pModel, TransacaoModel tModel) {
//		tModel.getListaMidia().add(pModel);
//		DataBase.getListaTransacao().add(tModel);
//	}
}
