package com.indracompany.stags.view.menu;
import java.util.Scanner;

import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ClienteModel;

public class MenuBuilder {
		
		public String executarMenuInicial() {
			
			System.out.println("\t\tMenu de opções:");
			System.out.println("\t1. Inserir cliente");
			System.out.println("\t2. Editar cliente");
//			System.out.println("\t3. Excluir cliente");
			System.out.println("\t0. Sair");
			
			return pedirEntrada("\nInsira sua opção: ");
		}

		public void inserirCliente(ClienteModel pModel) throws Exception {
			try {
				String nome, cpf;
				ClienteModel cliente = new ClienteModel();
				nome = pedirEntrada("\n Digite nome: ");
				if(nome != null && !nome.equals("")){
					pModel.setNome(nome);
				}else{
					throw new Exception("Não será possível.");
				}
				int idade = Integer.parseInt(pedirEntrada("\nDigite idade: "));
				pModel.setIdade(idade);
				cpf = pedirEntrada("\n Digite cpf: ");
				pModel.setCpf(cpf);
				pModel.setCodigo(cliente.getCodigo());
				DataBase.getListaCliente().add(pModel);
				DataBase.getCodigoCliente();
			} catch (Exception e) {
				throw new Exception("Erro ao tentar adicionar um cliente -> "+e.getMessage());
			}
		}
		
		public void editarCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome do cliente a ser editado: ");
			pModel.getNome();
			
			int posicaoLista = DataBase.getListaCliente().indexOf(pModel);	
			DataBase.getListaCliente().set(posicaoLista, pModel);
		}
		
		@SuppressWarnings("resource")
		public String pedirEntrada(String mensagemEntrada) {
			Scanner entrada = new Scanner(System.in);
			System.out.print(mensagemEntrada);
			return entrada.nextLine();
		}
}
