package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.TransacaoBOIf;
import com.indracompany.stags.dao.memory.TransacaoDAOMemory;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public class TransacaoBO implements TransacaoBOIf{
	private TransacaoDAOMemory transacaoDAO; 
	
	public TransacaoBO(){
		transacaoDAO = new TransacaoDAOMemory();
	}

	@Override
	public void inserir(TransacaoModel pModel) throws Exception {
		try {
			validate(pModel);
			transacaoDAO.inserir(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar realizar transação -> "+e.getMessage());
		}
	}

	@Override
	public List<TransacaoModel> listar() throws Exception {
		try {
			return transacaoDAO.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao tentar listar transações -> "+e.getMessage());
		}
	}
	
	@Override
	public void validate(TransacaoModel pModel)throws Exception {
		if(pModel != null){
			try {
				if(pModel.getCliente() == null || pModel.getCliente().equals("")){
					throw new Exception("Cliente é obrigatório");
				}
				if(pModel.getListaMidia() == null || pModel.getListaMidia().equals("")){
					throw new Exception("Não foram estabelecidas mídias");
				}
//				if(pModel.getValorTotal() == null || pModel.getValorTotal().equals("")){
//					throw new Exception("Não foram estabelecidos valores");
//				}
			} catch (Exception e) {
				throw new Exception("Erro ao tentar validar uma transação -> "+e.getMessage());				
			}
		}
	}

	@Override
	public void getValorTotal(TransacaoModel pModel)throws Exception {
		if(pModel != null){
			try {
				validate(pModel);
				transacaoDAO.getValorTotal(pModel);
			} catch (Exception e) {
				throw new Exception("Erro ao tentar realizar transação -> "+e.getMessage());
			}
		}
	}

	@Override
	public void setValorTotal(Double pModel)throws Exception {
		try {
			transacaoDAO.incrementarValorTotal(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar realizar transação -> "+e.getMessage());
		}
		
	}

	@Override
	public void diminuirQuantidade(MidiaModel pModel)throws Exception {
		try {
			Integer novaQuantidade = (pModel.getQuantidadeEstoque() - 1);
			pModel.setQuantidadeEstoque(novaQuantidade);			
		} catch (Exception e) {
			throw new Exception("Erro ao tentar reduzir quantidade de mídia -> "+e.getMessage());
		}		
	}
	

	@Override
	public void incrementarValorTotalVenda(MidiaModel pModel, TransacaoModel tModel)throws Exception {
		try {
			Double mModel = tModel.getValorTotal() + pModel.getValorVenda();
			tModel.setValorTotal(mModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar incrementar valor total -> "+e.getMessage());
		}
	}

	@Override
	public void incrementarValorTotalAluguel(MidiaModel pModel, TransacaoModel tModel)throws Exception {
		try {
			Double mModel = tModel.getValorTotal() + pModel.getValorAluguel();
			tModel.setValorTotal(mModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar incrementar valor total -> "+e.getMessage());
		}
	}

	@Override
	public void mostrarCompra(TransacaoModel pModel)throws Exception {
		if(pModel != null){
			try {
				validate(pModel);
				transacaoDAO.getValorTotal(pModel);
			} catch (Exception e) {
				throw new Exception("Erro ao tentar realizar transação -> "+e.getMessage());
			}
		}
	}
	
	@Override
	public String exibirHistoricoAluguelCliente(ClienteModel pModel) throws Exception {
		StringBuilder buffer = new StringBuilder();
		try{
			buffer.append("\n\nHistórico: ");
			int a=0;
			for(TransacaoModel transacao  : listar()){
				if(transacao.getCliente().equals(pModel) && transacao.getCompra()==false){
					buffer.append("\n" + transacao.toString());
					a++;
				}
			}
			if(a != 0) {
				return  buffer.toString();
			}
			if(a == 0) {
				buffer.append("Não houve transação relacionada a esse cliente. ");
				return buffer.toString();
			}
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}
		return buffer.toString();
	}

	@Override
	public String exibirHistoricoAluguelMidia(MidiaModel pModel) throws Exception {
		StringBuilder buffer = new StringBuilder();
		try{
			buffer.append("\n\nHistórico: ");
			int a=0;
			for(TransacaoModel transacao  : listar()){
				if(transacao.listaMidia.equals(pModel) && transacao.getCompra()==false){
					buffer.append("\n" + transacao.toString());
					a++;
				}
			}
			if(a != 0) {
				return  buffer.toString();
			}
			if(a == 0) {
				buffer.append("Não houve transação relacionada a essa mídia. ");
				return buffer.toString();			
			}
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}
		return buffer.toString();
	}
}
