package com.indracompany.stags.bo.ab;

import java.util.List;
import com.indracompany.stags.model.ClienteModel;

public interface ClienteBOIf {
	
	public void inserir(ClienteModel pModel) throws Exception;
	
	public void editar(ClienteModel pModel) throws Exception;
	
	public void excluir(ClienteModel pModel) throws Exception;
	
	public List<ClienteModel> listar() throws Exception;
	
	public ClienteModel buscar(ClienteModel pModel) throws Exception;

	public ClienteModel buscarCliente(String nome) throws Exception;
	
	public void validateIdade(int idade)throws Exception;
	
	public void validateCPF(String cpf)throws Exception;

	public void validateNome(String nome) throws Exception;
	
//	public static void validatePosicaoLista(int posicaoLista)throws Exception;
}
