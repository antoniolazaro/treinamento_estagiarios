package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.dao.ClienteDAOIf;
import com.indracompany.stags.dao.memory.ClienteDAOMemory;
import com.indracompany.stags.model.ClienteModel;

public class ClienteBO implements ClienteBOIf{
	private ClienteDAOIf clienteDAO;
	
	public ClienteBO(){
		clienteDAO = new ClienteDAOMemory();
	}

	@Override
	public void inserir(ClienteModel pModel) throws Exception {
		validate(pModel);
		try {
			clienteDAO.inserir(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar adicionar um cliente -> "+e.getMessage());
		}		
	}

	@Override
	public void editar(ClienteModel pModel) throws Exception {
		validate(pModel);
		try {
			clienteDAO.editar(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar editar um cliente -> "+e.getMessage());
		}
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		validate(pModel);
		try {
			clienteDAO.excluir(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar excluir um cliente -> "+e.getMessage());
		}
	}

	@Override
	public List<ClienteModel> listar() throws Exception {
		try {
			return clienteDAO.listar();
		} catch (Exception e) {
			throw new Exception("Erro ao tentar listar cliente -> "+e.getMessage());
		}
	}

	@Override
	public ClienteModel buscar(ClienteModel pModel) throws Exception {
		
		try {
			validate(pModel);
			return clienteDAO.buscar(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar um cliente -> "+e.getMessage());
		}
	}

	public void validate(ClienteModel pModel) throws Exception {
		if(pModel != null){
			if(pModel.getNome() == null || pModel.getNome().equals("")){
				throw new Exception("Nome é um campo obrigatório. ");
			}
		} 
	}
	
	public void validateNome(ClienteModel pModel) throws Exception {
		try {	
			if(pModel.getNome() == null || pModel.getNome() == ""){
				throw new Exception("Nome é um campo obrigatório. ");
			}
			if(pModel.getIdade() <= 0){
				throw new Exception("Idade não pode ser negativa. ");
			}
			if(pModel.getCpf() == null || pModel.getCpf() == ""){
				throw new Exception("CPF é um campo obrigatório. ");
			}
//			if(posicaoLista <= 0){
//				throw new Exception("Posição na lista tem de ser positiva. ");
//			}
		} catch (Exception e) {
			throw new Exception("Erro ao tentar validar um cliente -> "+e.getMessage());
		}
	}
	
	//método static.
	public static void validatePosicaoLista(int posicaoLista)throws Exception {
		try {
			if(posicaoLista <= 0){
				throw new Exception("Posição na lista tem de ser positiva. ");
			} 
		} catch (Exception e) {
			throw new Exception("Erro ao tentar validar um cliente -> "+e.getMessage());
		}
	}
	
	@Override
	public ClienteModel buscarCliente(String nome) throws Exception {
		try {
			if(nome != null || nome != ""){
				return clienteDAO.buscarCliente(nome);
			}
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar um cliente pelo nome -> "+e.getMessage());
		}
		return null;
	}

	@Override
	public void validateIdade(int idade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateCPF(String cpf) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
