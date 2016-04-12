package com.indracompany.stags.view.menu;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.MidiaBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.bo.ab.TransacaoBOIf;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public class MenuBuilder {
		private ClienteBOIf clienteBO;
		private MidiaBOIf midiaBO;
		private TransacaoBOIf transacaoBO;
		
		public MenuBuilder(){
			clienteBO = new ClienteBO();
			midiaBO = new MidiaBO();
			transacaoBO = new TransacaoBOIf();
		}
		public String executarMenuInicial() {
			
			System.out.println("\t\tMenu de opções:");
			System.out.println("\t1. Inserir cliente");
			System.out.println("\t2. Editar cliente");
			System.out.println("\t3. Excluir cliente");
			System.out.println("\t4. Inserir mídia");
			System.out.println("\t5. Editar mídia");
			System.out.println("\t6. Excluir mídia");
			System.out.println("\t7. Buscar cliente");
			System.out.println("\t8. Buscar mídia");
//			System.out.println("\t9. Vender");
			System.out.println("\t0. Sair");
			
			return pedirEntrada("\nInsira sua opção: ");
		}

		public void inserirCliente(ClienteModel pModel) throws Exception {
			String nome = "", cpf="";
			
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
				clienteBO.inserir(pModel);
				exibirTodos();
			} catch (Exception e) {
				throw new Exception("Erro ao tentar adicionar um cliente -> "+e.getMessage());
			}
		}
		
		public void editarCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome do cliente a ser editado: ");
			pModel = clienteBO.buscarCliente(nome);
			
			if(pModel !=null){
				
				boolean continuar = true;
				do{
					String opcaoSelecionadaMenuEditar = executarMenuEditar();
					try {
						switch(opcaoSelecionadaMenuEditar){
						case "a":
							String opcao1 = pedirEntrada("\n Digite novo nome: ");
							if(opcao1 != null && !opcao1.equals("")){
								pModel.setNome(opcao1);
							}
							clienteBO.editar(pModel);
							break;
							
						case "b":
							Integer opcao2 = Integer.parseInt(pedirEntrada("\n Digite nova idade: "));
							if(opcao2 != null && !opcao2.equals("")){
								pModel.setIdade(opcao2);
							}
							clienteBO.editar(pModel);
							break;
							
						case "c":
							String opcao3 = pedirEntrada("\n Digite novo CPF: ");
							if(opcao3 != null && !opcao3.equals("")){
								pModel.setCpf(opcao3);
							}
							clienteBO.editar(pModel);
							break;
							
						case "d":
		                	continuar = MainExecutorMenu.voltarPrograma();
							executarMenuInicial();
							break;

						default:
		                    System.out.printf("Você digitou uma opção inválida.");
		                    System.lineSeparator();
							break;
						}
					} catch (Exception e) {
						throw new Exception("Erro ao tentar editar um cliente -> "+e.getMessage());
					}
					
					}while(continuar);
			}
			}
		
		public void excluirCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome do cliente a ser excluído: ");
			pModel = clienteBO.buscarCliente(nome);
			try {
				if(pModel != null && !pModel.equals("")){
					pModel.setAtivo(false);
				}
				System.out.println("Cliente removido com sucesso: "+pModel.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar excluir um cliente -> "+e.getMessage());
			}
		}
		
		//Segue a parte de mídia
		public void inserirMidia(MidiaModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome: ");
			try {
				if(nome != null && !nome.equals("")){
					pModel.setNome(nome);
				}else{
					throw new Exception("Não será possível.");
				}
				Double valorVenda = Double.parseDouble(pedirEntrada("\nDigite valor de venda: "));
				pModel.setValorVenda(valorVenda);
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String dataRegistroStr = pedirEntrada("\n Digite data(Formato: dd/MM/yyyy): ");
				java.sql.Date dataRegistro = new java.sql.Date(format.parse(dataRegistroStr).getTime()); 
				pModel.setDataRegistro(dataRegistro);
				String tipoMidia = pedirEntrada("\nDigite tipo de mídia: ");
				pModel.setDescricao(tipoMidia);
				midiaBO.inserir(pModel);
				exibirTodos();
				System.out.println("Mídia inserida com sucesso: "+pModel.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar adicionar uma mídia -> "+e.getMessage());
			}
		}
		
		public void editarMidia(MidiaModel pModel) throws Exception {
			String nome = pedirEntrada("\n Digite nome da mídia a ser editada: ");
			pModel = midiaBO.buscarMidia(nome);
			
			if(pModel !=null){
				boolean continuar = true;
				do{
					String opcaoSelecionadaMenuEditarMidia = executarMenuEditarMidia();
					try {
						switch(opcaoSelecionadaMenuEditarMidia){
						case "a":
							String opcaoa = pedirEntrada("\n Digite novo nome: ");
							if(opcaoa != null && !opcaoa.equals("")){
								pModel.setNome(opcaoa);
								midiaBO.editar(pModel);
							}

						case "b":
							Double opcaob = Double.parseDouble(pedirEntrada("\nDigite novo valor de venda: "));
							if(opcaob != null && !opcaob.equals("")){
								pModel.setValorVenda(opcaob);
								midiaBO.editar(pModel);
							}
							
						case "c":
							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							String opcaoc = pedirEntrada("\n Digite nova data de registro(Formato: dd/MM/yyyy): ");
							java.sql.Date dataRegistro = new java.sql.Date(format.parse(opcaoc).getTime()); 
							pModel.setDataRegistro(dataRegistro);
							midiaBO.editar(pModel);
							
						case "d":
							String opcaod = pedirEntrada("\nDigite novo tipo de mídia: ");
							if(opcaod != null && !opcaod.equals("")){
								pModel.setDescricao(opcaod);
								midiaBO.editar(pModel);
							}
							
						case "e":
		                	continuar = MainExecutorMenu.voltarPrograma();
							executarMenuInicial();						
							
						default:
		                    System.out.printf("Você digitou uma opção inválida.");
		                    System.lineSeparator();
						}
						break;
					} catch (Exception e) {
						throw new Exception("Erro ao tentar editar uma mídia -> "+e.getMessage());
			}				
				}while(continuar);
			    }			
			}
		
		public void excluirMidia(MidiaModel midia) throws Exception {
			String nome = pedirEntrada("\n Digite nome da mídia a ser excluída: ");
			midia = midiaBO.buscarMidia(nome);
			try {
				if(midia != null && !midia.equals("")){
					midia.setAtivo(false);
				}
				System.out.println("Mídia removida com sucesso: "+midia.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar excluir uma mídia -> "+e.getMessage());
			}
		}
		
		public void buscarCliente(ClienteModel cliente) throws Exception {
			String nome = pedirEntrada("\n Digite nome do cliente a detalhar: ");
			clienteBO.buscarCliente(nome);
		}		
		
		public void buscarMidia(MidiaModel midia) throws Exception {
			String nome = pedirEntrada("\n Digite nome da mídia a detalhar: ");
			midiaBO.buscarMidia(nome);
		}
				
		public void vender(TransacaoModel transacaoBO) {
			
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
		
		public String executarMenuEditarMidia() {
		       System.out.println("\t\tMenu de opções:");
		       System.out.println("\ta. Editar nome");
		       System.out.println("\tb. Editar valor de venda");
		       System.out.println("\tc. Editar data de registro");
		       System.out.println("\td. Editar tipo de mídia");
		       System.out.println("\te. Sair");
		        		
		       return pedirEntrada("\nInsira sua opção: ");
		}
		
		public void exibirTodos() throws Exception{
			List<ClienteModel> listaCliente = clienteBO.listar();
			if(listaCliente != null && listaCliente.size()>0){
				for(ClienteModel cliente:listaCliente){
					System.out.println(cliente);
				}
			}
		}
}
