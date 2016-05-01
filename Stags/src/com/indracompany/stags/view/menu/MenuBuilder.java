package com.indracompany.stags.view.menu;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.MidiaBO;
import com.indracompany.stags.bo.TransacaoBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.bo.ab.TransacaoBOIf;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TipoDeMidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public class MenuBuilder {
		private ClienteBOIf clienteBO;
		private MidiaBOIf midiaBO;
		private TransacaoBOIf transacaoBO;
    	String quebraLinha = System.getProperty("line.separator");
		
		public MenuBuilder(){
			clienteBO = new ClienteBO();
			midiaBO = new MidiaBO();
			transacaoBO = new TransacaoBO();
		}
		public String executarMenuInicial(){
			System.out.println("\t\tMenu de opções:" + quebraLinha + quebraLinha);
			System.out.println("Área de Cliente:");
			System.out.println("\t1. Inserir cliente");
			System.out.println("\t2. Editar cliente");
			System.out.println("\t3. Excluir cliente");
			System.out.println("\t4. Buscar cliente");
			System.out.println("\t5. Exibir histórico de alugueis de um cliente" + quebraLinha);
			System.out.println("Área de Mídia:");
			System.out.println("\t6. Inserir mídia");
			System.out.println("\t7. Editar mídia");
			System.out.println("\t8. Excluir mídia");
			System.out.println("\t9. Buscar mídia por nome");
			System.out.println("\t10. Buscar mídia por código");
			System.out.println("\t11. Exibir media de preço de venda ou aluguel das mídias da loja");
			System.out.println("\t12. Exibir produto mais caro e mais barato em venda ou aluguel");
			System.out.println("\t13. Exibir histórico de alugueis de uma mídia da loja" + quebraLinha);
			System.out.println("Área de Transação:");
			System.out.println("\t14. Vender");
			System.out.println("\t15. Alugar" + quebraLinha);
			System.out.println("\t0. Sair");
			
			return pedirEntrada("\nInsira sua opção: ");
		}
		
		public void inserirCliente() throws Exception {
			String nome="", cpf="";
			ClienteModel pModel = new ClienteModel();
			nome = pedirEntrada(quebraLinha + "Digite nome: ");
			pModel.setNome(nome);
			CharSequence idade = pedirEntrada(quebraLinha + "Digite idade: ");
			if(idade  != null && !idade.equals("") && clienteBO.validateCampoNumero(idade)){
				int valor = Integer.parseInt((String) idade);
				pModel.setIdade(valor);
				cpf = pedirEntrada(quebraLinha + "Digite cpf válido: ");
				pModel.setCpf(cpf);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				pModel.setDataRegistro(dateFormat.format(date));
				clienteBO.validate(pModel);
				clienteBO.inserir(pModel);
                System.out.printf(quebraLinha + "Cliente inserido com sucesso." + quebraLinha + quebraLinha);
			} else {
				throw new Exception("Formato inválido.");
			}
		}
		
		public void editarCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada(quebraLinha + "Digite nome do cliente a ser editado: ");
			pModel = clienteBO.buscarCliente(nome);			
			if(pModel !=null){				
				boolean continuar = true;
				do{
		        	try{
						String opcaoSelecionadaMenuEditar = executarMenuEditar();
							switch(opcaoSelecionadaMenuEditar){
							case "a":
								String opcao1 = pedirEntrada(quebraLinha + "Digite novo nome: ");
								if(opcao1 != null && !opcao1.equals("")){
									pModel.setNome(opcao1);
									clienteBO.validate(pModel);
									clienteBO.editar(pModel);
					                System.out.printf(quebraLinha + "Nome editado com sucesso." + quebraLinha);
								}
								break;
								
							case "b":
								CharSequence idade = pedirEntrada(quebraLinha + "Digite nova idade: ");
								if(idade != null && !idade.equals("") && clienteBO.validateCampoNumero(idade)){
									Integer opcao2 = Integer.parseInt((String) idade);
									pModel.setIdade(opcao2);
									clienteBO.validate(pModel);
									clienteBO.editar(pModel);
					                System.out.printf(quebraLinha + "Idade editada com sucesso." + quebraLinha);
								} else {
									throw new Exception("Formato inválido.");
								}
								break;
								
							case "c":
								String opcao3 = pedirEntrada(quebraLinha + "Digite novo CPF válido: ");;
								if(opcao3 != null && !opcao3.equals("")){
									pModel.setCpf(opcao3);
									clienteBO.validate(pModel);
									clienteBO.editar(pModel);
					                System.out.printf(quebraLinha + "CPF editado com sucesso." + quebraLinha);
								}
								break;

							case "d":
								pModel.setAtivo(true);
								clienteBO.validate(pModel);
								clienteBO.editar(pModel);	
				                System.out.printf(quebraLinha + "Cliente reativado com sucesso." + quebraLinha);					
								break;
								
							case "e":
			                	continuar = MainExecutorMenu.voltarPrograma();
								break;
	
							default:
			                    System.out.printf("Você digitou uma opção inválida.");
			                    System.lineSeparator();
								break;
							}
		            }catch(Exception ex){
			        	System.err.println("LOG DE ERRO: "+ex.getMessage());
			        }					
				}while(continuar);
			}
			}
		
		public void excluirCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada(quebraLinha + "Digite nome do cliente a ser excluído: ");
			pModel = clienteBO.buscarCliente(nome);
			try {
				if(pModel != null && !pModel.equals("")){
					clienteBO.excluir(pModel);
					System.out.println("Cliente removido com sucesso: "+pModel.toString());
				}
			} catch (Exception e) {
				throw new Exception("Erro ao tentar excluir um cliente -> "+e.getMessage());
			}
		}
		
		public void buscarCliente(ClienteModel pModel) throws Exception {
			String nome = pedirEntrada(quebraLinha + "Digite nome do cliente a detalhar: ");
			try {
				if(pModel.getAtivo() != false){
					clienteBO.buscarCliente(nome);	
				} else 
					throw new Exception("Cliente não encontrado. ");
			} catch (Exception e) {	
				throw new Exception("Erro ao tentar buscar um cliente -> "+e.getMessage());
			}
		}
		
		public void exibirHistoricoAluguelCliente(ClienteModel pModel) throws Exception {
			try {
				String nomeCliente = pedirEntrada(quebraLinha + "Digite nome do cliente a fim de obter seu histórico: ");
				ClienteModel mModel = clienteBO.buscarCliente(nomeCliente);
		    	System.out.printf("\nHistórico: \n");
				System.out.println(transacaoBO.exibirHistoricoAluguelCliente(mModel));
			} catch (Exception e) {
				throw new Exception("Não foi possível ");
			}
		}
		
		//Segue a parte de mídia
		public void inserirMidia() throws Exception {
			MidiaModel pModel = new MidiaModel();
			String nome = pedirEntrada(quebraLinha + "Digite nome: ");
			try {
				pModel.setNome(nome);
				String descricao = pedirEntrada(quebraLinha + "Digite descrição: ");
				pModel.setDescricao(descricao);
				String codBarras = pedirEntrada(quebraLinha + "Digite código de barras: ");
				pModel.setCodigoBarras(codBarras);
				Double venda = Double.parseDouble((String) pedirEntrada(quebraLinha + "Digite valor de venda: Formato(xx.xx)"));
				if(venda  != null && !venda.equals("")){
					pModel.setValorVenda(venda);
				} else {
					throw new Exception("Formato do valor de venda inválido.");
				}
				Double valorAluguel = Double.parseDouble(pedirEntrada(quebraLinha + "Digite valor de aluguel: Formato(xx.xx)"));
				if(valorAluguel  != null && !valorAluguel.equals("")){
					pModel.setValorAluguel(valorAluguel);
				} else {
					throw new Exception("Formato do valor do aluguel inválido.");
				}				
	//			Data automática
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				pModel.setDataRegistro(dateFormat.format(date));
	//			Pedindo data:
	//			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	//			String dataRegistroStr = pedirEntrada("\nDigite data(Formato: dd/MM/yyyy): ");
	//			java.sql.Date dataRegistro = new java.sql.Date(format.parse(dataRegistroStr).getTime());
	//			pModel.setDataRegistro(dataRegistro);
				CharSequence estoque = pedirEntrada(quebraLinha + "Digite quantidade em estoque: ");
				if(estoque  != null && !estoque.equals("")){
					if(midiaBO.validateCampoNumero(estoque)){
						Integer quantidadequantidadeEstoque = Integer.parseInt((String) estoque);
						pModel.setQuantidadeEstoque(quantidadequantidadeEstoque);
					} else {
						throw new Exception("Campo quantidade não aceita letras.");
					}
				} else {
					throw new Exception("Formato da quantidade em estoque inválida.");
				}
				tipoMidiaInserirMenu(pModel);	
				midiaBO.validate(pModel);			
				midiaBO.inserir(pModel);
	//			exibirTodos();
				System.out.println("Mídia inserida com sucesso: "+pModel.toString());
			} catch (Exception e) {
				throw new Exception("Erro ao tentar adicionar uma mídia -> "+e.getMessage());
			}
		}
		
		public void editarMidia(MidiaModel pModel) throws Exception {
			String nome = pedirEntrada(quebraLinha + "Digite nome da mídia a ser editada: ");
			pModel = midiaBO.buscarMidia(nome);			
			if(pModel !=null){
				boolean continuar = true;
				do{
					String opcaoSelecionadaMenuEditarMidia = executarMenuEditarMidia();
					try {
						switch(opcaoSelecionadaMenuEditarMidia){
						case "a":
							String opcaoa = pedirEntrada(quebraLinha + "Digite novo nome: ");
							pModel.setNome(opcaoa);
							midiaBO.validate(pModel);
							midiaBO.editar(pModel);
			                System.out.printf(quebraLinha + "Nome editado com sucesso." + quebraLinha);
							break;

						case "b":

							Double valorVenda = Double.parseDouble(pedirEntrada(quebraLinha + "Digite valor de venda: "));
							if(valorVenda != null && !valorVenda.equals("")){
								pModel.setValorVenda(valorVenda);
								midiaBO.validate(pModel);
								midiaBO.editar(pModel);
				                System.out.printf(quebraLinha + "Valor de Venda editado com sucesso." + quebraLinha);
							}else {
								throw new Exception("Formato inválido.");
							}
							break;
							
						case "c":
							Double valorAluguel = Double.parseDouble(pedirEntrada(quebraLinha + "Digite valor de aluguel: "));
							if(valorAluguel != null && !valorAluguel.equals("")){
								pModel.setValorAluguel(valorAluguel);
								midiaBO.validate(pModel);
								midiaBO.editar(pModel);
				                System.out.printf(quebraLinha + "Valor de Aluguel editado com sucesso." + quebraLinha);
							}else {
								throw new Exception("Formato inválido.");
							}
							break;
							
						case "d":							
							tipoMidiaEditarMenu(pModel); 
			                System.out.printf(quebraLinha + "Tipo de mídia editada com sucesso." + quebraLinha);
							break;
						
						case "e":					
							CharSequence estoque = pedirEntrada(quebraLinha + "Digite nova quantidade em estoque: ");
							if(estoque  != null && !estoque.equals("")){
								if(midiaBO.validateCampoNumero(estoque)){
									Integer quantidadequantidadeEstoque = Integer.parseInt((String) estoque);
									pModel.setQuantidadeEstoque(quantidadequantidadeEstoque);
								} else {
									throw new Exception("Campo quantidade não aceita letras.");
								}
							} else {
								throw new Exception("Formato da quantidade em estoque inválida.");
							}
							midiaBO.validate(pModel);
							midiaBO.editar(pModel);
			                System.out.printf(quebraLinha + "Quantidade editada com sucesso." + quebraLinha);
							break;
							
						case "f":
							pModel.setAtivo(true);
							midiaBO.validate(pModel);
							midiaBO.editar(pModel);
			                System.out.printf(quebraLinha + "Mídia reativada com sucesso." + quebraLinha);
							break;
						
						case "g":		
		                	continuar = MainExecutorMenu.voltarPrograma();
		        			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		        			Date date = new Date();
		        			pModel.setDataRegistro(dateFormat.format(date));
							break;
							
						default:
		                    System.out.printf("Você digitou uma opção inválida.");
		                    System.lineSeparator();
		                    break;
						}
						break;
					} catch (Exception e) {
						throw new Exception("Erro ao tentar editar uma mídia -> "+e.getMessage());
					}						
				}while(continuar);
			    }			
		}
		
		public void tipoMidiaInserirMenu(MidiaModel pModel) throws Exception {
			if(pModel !=null){
				boolean continuar = true;
				do{
					try {
						String opcaoSelecionadaMenuTipoMidia = executarMenuInserirTipoMidia();
							switch(opcaoSelecionadaMenuTipoMidia){
							case "a":	
								pModel.setTipoMidia(TipoDeMidiaModel.DVD);			
								continuar = false;
								break;
								
							case "b":
								pModel.setTipoMidia(TipoDeMidiaModel.BLURAY);
								continuar = false;
								break;
								
							case "c":					
								pModel.setTipoMidia(TipoDeMidiaModel.STREAMING);
								continuar = false;
								break;
								
							default:
			                    System.out.printf("Você digitou uma opção inválida.");
			                    System.lineSeparator();
			                    break;
							}
						} catch (Exception e) {
							throw new Exception("Erro ao tentar estabelecer tipo de mídia -> "+e.getMessage());  	
						}
					} while(continuar); 
			} else {
				throw new Exception("Não é possível realizar a ação.");
			}			    
		}
		
		public void tipoMidiaEditarMenu(MidiaModel pModel) throws Exception {			
			if(pModel !=null){
				boolean continuar = true;
				do{
					String opcaoSelecionadaMenuTipoMidia = executarMenuEditarTipoMidia();
					try {
						switch(opcaoSelecionadaMenuTipoMidia){
						case "a":	
							pModel.setTipoMidia(TipoDeMidiaModel.DVD); 
							continuar = false;
							break;
							
						case "b":	
							pModel.setTipoMidia(TipoDeMidiaModel.BLURAY); 
							continuar = false;
							break;
							
						case "c":			
							pModel.setTipoMidia(TipoDeMidiaModel.STREAMING); 
							continuar = false;
							break;
							
						case "d":
		                	continuar = MainExecutorMenu.voltarPrograma();
		                	break;	
		                	
						default:
		                    System.out.printf("Você digitou uma opção inválida.");
		                    System.lineSeparator();
		                    break;
		                    
						}
					} catch (Exception e) {
						throw new Exception("Erro ao tentar estabelecer tipo de mídia -> "+e.getMessage());	
					}
				}while(continuar);
			    }			
		}	
		
		public void excluirMidia(MidiaModel pModel) throws Exception {
			String nome = pedirEntrada(quebraLinha + "Digite nome da mídia a ser excluída: ");
			try {
				pModel = midiaBO.buscarMidia(nome);
				if(pModel != null && !pModel.equals("")){
					midiaBO.excluir(pModel);					
				}
				System.out.println("Mídia removida com sucesso: "+pModel.toString());
			} catch (Exception e) {	
				throw new Exception("Erro ao tentar excluir uma mídia -> "+e.getMessage());
			}
		}	
		
		public void buscarMidia(MidiaModel pModel) throws Exception {
			String nome = pedirEntrada(quebraLinha + "Digite nome da mídia a detalhar: ");
			try {
				if(pModel.getAtivo() != false){
					midiaBO.buscarMidia(nome);		
				} else 
					throw new Exception("Mídia não encontrado. ");
			} catch (Exception e) {	
				throw new Exception("Erro ao tentar buscar uma mídia -> "+e.getMessage());
			}
		}		
		
		public void buscar(MidiaModel pModel) throws Exception {
			try {
				Long codigo = Long.parseLong(pedirEntrada(quebraLinha + "Digite código da mídia a detalhar: "));
				if(pModel.getAtivo() != false){
					midiaBO.buscar(codigo);
				} else
					throw new Exception("Mídia não encontrada. ");	
			} catch (Exception e) {
				throw new Exception("Formato inválido ");
			}
		}
		
		public void exibirMidiaPrecoVendaAluguel() throws Exception {
			try {
				System.out.println(midiaBO.exibirMidiaPrecoVendaAluguel());
			} catch (Exception e) {
				throw new Exception("Não foi possível ");
			}
		}
		
		public void exibirMidiaPrecoMaisBaratoCaroVendaAluguel() throws Exception {
			try {
				System.out.println(midiaBO.exibirMidiaPrecoMaisBaratoCaroVendaAluguel());
			} catch (Exception e) {
				throw new Exception("Não foi possível ");
			}
		}
		
		public void exibirHistoricoAluguelMidia(MidiaModel pModel) throws Exception {
			try {
				String nomeMidia = pedirEntrada(quebraLinha + "Digite nome da mídia a fim de obter histórico: ");
				MidiaModel mModel = midiaBO.buscarMidia(nomeMidia);
		    	System.out.println(transacaoBO.exibirHistoricoAluguelMidia(mModel));
			} catch (Exception e) {
				throw new Exception("Não foi possível ");
			}
		}
		
		//método vender
		public void vender(ClienteModel pModel, MidiaModel lModel) {
			try{
				TransacaoModel tModel = new TransacaoModel();
				String nomeMidia = null;
				String nomeCliente = pedirEntrada(quebraLinha + "Digite nome do cliente a comprar: ");
				pModel = clienteBO.buscarCliente(nomeCliente);
				if(pModel == null || pModel.getAtivo() == false){
					throw new Exception("Cliente inválido ");
				}
				tModel.setCliente(pModel);
				tModel.setValorTotal((double) 0);
				do{
					nomeMidia = pedirEntrada(quebraLinha + "Digite nome da mídia a comprar" + quebraLinha + "(para cancelar, digite N): ");
				    if(!nomeMidia.equalsIgnoreCase("N")){
						lModel = midiaBO.buscarMidia(nomeMidia);
						tModel.setCompra(true);
						transacaoBO.incrementarValorTotalVenda(lModel, tModel);
						transacaoBO.diminuirQuantidade(lModel);
				    	tModel.addMidia(lModel);
				    	System.out.printf("Mídia adicionada com sucesso. ");
				    }		                    
				}while(nomeMidia != null && !nomeMidia.equalsIgnoreCase("N"));
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				tModel.setDataRegistro(dateFormat.format(date));
				clienteBO.validate(pModel);
				midiaBO.validate(lModel);	
				transacaoBO.inserir(tModel);
				System.out.println(quebraLinha + "Compra realizada com sucesso." + quebraLinha + quebraLinha + tModel.toString());
	       }catch(Exception ex){
	        	System.err.println("LOG DE ERRO: "+ex.getMessage());
	       }						
		}
		
		//método alugar
				public void alugar(ClienteModel pModel, MidiaModel lModel) {
					try{
						TransacaoModel tModel = new TransacaoModel();
						String nomeMidia = null;
						String nomeCliente = pedirEntrada(quebraLinha + "Digite nome do cliente a alugar: ");
						pModel = clienteBO.buscarCliente(nomeCliente);
						if(pModel == null || pModel.getAtivo() == false){
							throw new Exception("Cliente inválido ");
						}
						tModel.setCliente(pModel);
						tModel.setValorTotal((double) 0);
						do{
							nomeMidia = pedirEntrada(quebraLinha + "Digite nome da mídia a alugar" + quebraLinha + "(para cancelar, digite N): ");
						    if(!nomeMidia.equalsIgnoreCase("N")){
								lModel = midiaBO.buscarMidia(nomeMidia);
								tModel.setCompra(false);
								transacaoBO.incrementarValorTotalAluguel(lModel, tModel);
								transacaoBO.diminuirQuantidade(lModel);
						    	tModel.addMidia(lModel);
						    	System.out.printf("Mídia adicionada com sucesso. ");
						    }		                    
						}while(nomeMidia != null && !nomeMidia.equalsIgnoreCase("N"));
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Date date = new Date();
						tModel.setDataRegistro(dateFormat.format(date));
						clienteBO.validate(pModel);
						midiaBO.validate(lModel);
						transacaoBO.inserir(tModel);
						System.out.println(quebraLinha + "Aluguel realizada com sucesso." + quebraLinha + quebraLinha + tModel.toString());
						tModel.toString();
			       }catch(Exception ex){
			        	System.err.println("LOG DE ERRO: "+ex.getMessage());
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
		       System.out.println("\td. Reativar cliente");
		       System.out.println("\te. Sair");
		        		
		       return pedirEntrada(quebraLinha + "Insira sua opção: ");
		}
		
		public String executarMenuEditarMidia() {
		       System.out.println("\t\tMenu de opções:");
		       System.out.println("\ta. Editar nome");
		       System.out.println("\tb. Editar valor de venda");
		       System.out.println("\tc. Editar valor de aluguel");
		       System.out.println("\td. Editar tipo de mídia");
		       System.out.println("\te. Editar quantidade em estoque");
		       System.out.println("\tf. Reativar mídia");
		       System.out.println("\tg. Sair");
		        		
		       return pedirEntrada(quebraLinha + "Insira sua opção: ");
		}
		
		public String executarMenuEditarTipoMidia() {
		       System.out.println("\t\tTipo de mídia a editar:");
		       System.out.println("\ta. DVD");
		       System.out.println("\tb. BLU-RAY");
		       System.out.println("\tc. STREAMING");
		       System.out.println("\td. Sair");
		        		
		       return pedirEntrada(quebraLinha + "Insira sua opção: ");
		}
		
		public String executarMenuInserirTipoMidia() {
		       System.out.println("\t\tTipo de mídia a inserir:");
		       System.out.println("\ta. DVD");
		       System.out.println("\tb. BLU-RAY");
		       System.out.println("\tc. STREAMING");
		        		
		       return pedirEntrada(quebraLinha + "Insira sua opção: ");
		}
		
		public void exibirTodos() throws Exception{
			List<ClienteModel> listaCliente = clienteBO.listar();
			if(listaCliente != null && listaCliente.size()>0){
				for(ClienteModel cliente:listaCliente){
					System.out.println(cliente);
				}
			}
			
			List<MidiaModel> listaMidia = midiaBO.listar();
			if(listaMidia != null && listaMidia.size()>0){
				for(MidiaModel midia:listaMidia){
					System.out.println(midia);
				}
			}
		}		
}
