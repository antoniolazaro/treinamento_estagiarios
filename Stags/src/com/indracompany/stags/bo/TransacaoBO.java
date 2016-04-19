package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.TransacaoBOIf;
import com.indracompany.stags.dao.memory.TransacaoDAOMemory;
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
}
