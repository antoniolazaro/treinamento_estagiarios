package com.indracompany.stags.view.menu;
import java.util.Scanner;

import com.indracompany.stags.dao.memory.ClienteDAOMemory;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ClienteModel;

public class MenuBuilder {
		
		public String executarMenuInicial() {
			
			System.out.println("\t\tMenu de opções:");
			System.out.println("\t1. Inserir cliente");
			System.out.println("\t2. Editar cliente");
			System.out.println("\t3. Excluir cliente");
			System.out.println("\t0. Sair");
			
			return pedirEntrada("\nInsira sua opção: ");
		}

		public void inserirCliente(ClienteModel pModel) throws Exception {
			String nome, cpf;
			ClienteModel cliente = new ClienteModel();
			nome = pedirEntrada("\n Digite nome: ");
			try {
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
				System.out.println("Cliente inserido com sucesso: "+pModel.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar adicionar um cliente -> "+e.getMessage());
			}
		}
		
		public void editarCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome do cliente a ser editado: ");
			ClienteDAOMemory.buscarCliente(nome);
			String opcaoSelecionadaMenuEditar = executarMenuEditar();
			boolean continuar = true;
			try {
				do{
					switch(opcaoSelecionadaMenuEditar){
					case "a":
						String opcao1 = pedirEntrada("\n Digite novo nome: ");
						if(opcao1 != null && !opcao1.equals("")){
							pModel.setNome(opcao1);
						}else{
							return;
						}
						break;
					case "b":
						Integer opcao2 = Integer.parseInt(pedirEntrada("\n Digite nova idade: "));
						if(opcao2 != null && !opcao2.equals("")){
							pModel.setIdade(opcao2);
						}else{
							return;
						}
						break;	
					case "c":
						String opcao3 = pedirEntrada("\n Digite novo CPF: ");
						if(opcao3 != null && !opcao3.equals("")){
							pModel.setCpf(opcao3);
						}else{
							return;
						}							
						break;
					case "d":
						break;
					default: 
						break;
					}						
				}while(continuar);
				System.out.println("Cliente editado com sucesso: "+pModel.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar editar um cliente -> "+e.getMessage());
			}
			
			int posicaoLista = DataBase.getListaCliente().indexOf(pModel);	
			DataBase.getListaCliente().set(posicaoLista, pModel);
			}
		
		public void excluirCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome do cliente a ser excluído: ");
			ClienteDAOMemory.buscarCliente(nome);
			try {
				if(pModel != null && !pModel.equals("")){
					pModel.setAtivo(false);
				}
				System.out.println("Cliente removido com sucesso: "+pModel.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar excluir um cliente -> "+e.getMessage());
			}
		}
		
		@SuppressWarnings("resource")
		public String pedirEntrada(String mensagemEntrada) {
			Scanner entrada = new Scanner(System.in);
			System.out.print(mensagemEntrada);
			return entrada.nextLine();
		}
		
		public String executarMenuEditar() {
		       System.out.println("\t\tMenu de opções:");
		       System.out.println("\ta. Editar nome");
		       System.out.println("\tb. Editar idade");
		       System.out.println("\tc. Editar cpf");
		       System.out.println("\td. Sair");
		        		
		       return pedirEntrada("\nInsira sua opção: ");
		}
}
