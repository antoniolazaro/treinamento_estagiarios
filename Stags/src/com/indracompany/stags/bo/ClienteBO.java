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
		try {
			validate(pModel);
			clienteDAO.inserir(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar adicionar um cliente -> "+e.getMessage());
		}		
	}

	@Override
	public void editar(ClienteModel pModel) throws Exception {
		try {
			validate(pModel);
			clienteDAO.editar(pModel);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar editar um cliente -> "+e.getMessage());
		}
	}

	@Override
	public void excluir(ClienteModel pModel) throws Exception {
		try {
			validate(pModel);
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
			try {	
				if(pModel.getNome() == null || pModel.getNome().equals("")){
					throw new Exception("\nNome é um campo obrigatório. ");
				}
				
				if(pModel.getIdade() <= 0){
					throw new Exception("Idade não pode ser negativa. ");
				}
				
				// considera-se erro CPF's formados por uma sequencia de numeros iguais 
				if (pModel.getCpf().equals("00000000000") || pModel.getCpf().equals("11111111111") || pModel.getCpf().equals("22222222222") || pModel.getCpf().equals("33333333333") || pModel.getCpf().equals("44444444444") || pModel.getCpf().equals("55555555555") || pModel.getCpf().equals("66666666666") || pModel.getCpf().equals("77777777777") || pModel.getCpf().equals("88888888888") || pModel.getCpf().equals("99999999999") || (pModel.getCpf().length() != 11))
					throw new Exception("Formato de CPF inválido. ");
				char dig10, dig11; 
				int sm, i, r, num, peso;
				// "try" - protege o codigo para eventuais erros de conversao de tipo (int) 
				try {
						// Calculo do 1o. Digito Verificador 
						sm = 0; 
						peso = 10;
						for (i=0; i<9; i++) {
							// converte o i-esimo caractere do CPF em um numero:
							// por exemplo, transforma o caractere '0' no inteiro 0 
							// (48 eh a posicao de '0' na tabela ASCII) 
							num = (int)(pModel.getCpf().charAt(i) - 48);
							sm = sm + (num * peso); 
							peso = peso - 1;
						}
						r = 11 - (sm % 11);
						if ((r == 10) || (r == 11)) 
							dig10 = '0';
						else dig10 = (char)(r + 48); 
						// converte no respectivo caractere numerico
						// Calculo do 2o. Digito Verificador 
						sm = 0;
						peso = 11; 
						for(i=0; i<10; i++) {
							num = (int)(pModel.getCpf().charAt(i) - 48);
							sm = sm + (num * peso); 
							peso = peso - 1;
						}
						r = 11 - (sm % 11);
						if ((r == 10) || (r == 11))
							dig11 = '0';
						else dig11 = (char)(r + 48); 
						// Verifica se os digitos calculados conferem com os digitos informados.
						if ((dig10 != pModel.getCpf().charAt(9)) || (dig11 != pModel.getCpf().charAt(10)))
							throw new Exception("CPF inválido. ");
				} catch (Exception e) {
					throw new Exception("Erro ao tentar validar CPF -> "+e.getMessage());
				}
			} catch (Exception e) {
				throw new Exception("Erro ao tentar validar um cliente -> "+e.getMessage());
			}
		} 
	}
	
	//método static.
	public static void validatePosicaoLista(int posicaoLista)throws Exception {
		try {
			if(posicaoLista < 0){
				throw new Exception("Posição na lista tem de ser positiva. ");
			} 
		} catch (Exception e) {
			throw new Exception("Erro ao tentar validar um cliente -> "+e.getMessage());
		}
	}
	
	@Override
	public ClienteModel buscarCliente(String nome) throws Exception {
		try {
			return clienteDAO.buscarCliente(nome);
		} catch (Exception e) {
			throw new Exception("Erro ao tentar buscar um cliente pelo nome -> "+e.getMessage());
		}
	}
}
