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
			throw new Exception("Erro ao tentar realizar transa��o -> "+e.getMessage());
		}
	}

	@Override
	public List<TransacaoModel> listar() throws Exception {
		try {
			return transacaoDAO.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao tentar listar transa��es -> "+e.getMessage());
		}
	}
	
	@Override
	public void validate(TransacaoModel pModel)throws Exception {
		if(pModel != null){
			try {
				if(pModel.getCliente() == null || pModel.getCliente().equals("")){
					throw new Exception("Cliente � obrigat�rio");
				}
				if(pModel.getListaMidia() == null || pModel.getListaMidia().equals("")){
					throw new Exception("N�o foram estabelecidas m�dias");
				}
//				if(pModel.getValorTotal() == null || pModel.getValorTotal().equals("")){
//					throw new Exception("N�o foram estabelecidos valores");
//				}
			} catch (Exception e) {
				throw new Exception("Erro ao tentar validar uma transa��o -> "+e.getMessage());				
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
				throw new Exception("Erro ao tentar realizar transa��o -> "+e.getMessage());
			}
		}
	}

	@Override
	public void setValorTotal(Double pModel)throws Exception {
		try {
			transacaoDAO.incrementarValorTotal(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar realizar transa��o -> "+e.getMessage());
		}
		
	}

	@Override
	public void diminuirQuantidade(MidiaModel pModel)throws Exception {
		try {
			Integer novaQuantidade = (pModel.getQuantidadeEstoque() - 1);
			pModel.setQuantidadeEstoque(novaQuantidade);			
		} catch (Exception e) {
			throw new Exception("Erro ao tentar reduzir quantidade de m�dia -> "+e.getMessage());
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
				throw new Exception("Erro ao tentar realizar transa��o -> "+e.getMessage());
			}
		}
	}
	
	@Override
	public String exibirHistoricoAluguelCliente(ClienteModel pModel) throws Exception {
		try {
			return transacaoDAO.exibirHistoricoAluguelCliente(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar exibir hist�rico de aluguel de um cliente -> "+e.getMessage());
		}
	}

	@Override
	public String exibirHistoricoAluguelMidia(MidiaModel pModel) throws Exception {
		try {
			return transacaoDAO.exibirHistoricoAluguelMidia(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar exibir -> "+e.getMessage());
		}
	}
}