package com.indracompany.stags.view.menu;

import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;

public class MainExecutorMenu {
		    
	    public static void main (String [] Args) throws Exception {
	    	String quebraLinha = System.getProperty("line.separator");
			boolean continuar=true;
	    	String opcao;
	        ClienteModel cliente = new ClienteModel();
	        MidiaModel midia = new MidiaModel();
	        MenuBuilder menuBuilder = new MenuBuilder();
	        
	        do{
	        	try{
	        		opcao = menuBuilder.executarMenuInicial();
		            switch( opcao )
		            {
		                case "1":
		                	menuBuilder.inserirCliente();
		                    break;        
		                    
		                case "2":
		                	menuBuilder.editarCliente(cliente);
		                    break;
		                    
		                case "3":
		                	menuBuilder.excluirCliente(cliente);	                   
		                    break;
		                    
		                case "4":
		                	menuBuilder.buscarCliente(cliente);
		                    break;        
		                    
		                case "5":
		                	menuBuilder.exibirHistoricoAluguelCliente(cliente);
		                    break;		                    
		                    
		                case "6":
		                	menuBuilder.inserirMidia();
		                    break;
		                    
		                case "7":
		                	menuBuilder.editarMidia(midia);                   
		                    break;
		                    
		                case "8":
		                	menuBuilder.excluirMidia(midia);	    
		                    break;
		                    
		                case "9":
		                	menuBuilder.buscarMidia(midia);                
		                    break;
		                    
		                case "10":
		                	menuBuilder.buscar(midia);                
		                    break;
		                    
		                case "11":
		                	menuBuilder.exibirMidiaPrecoVendaAluguel();                
		                    break;
		                    
		                case "12":
		                	menuBuilder.exibirMidiaPrecoMaisBaratoCaroVendaAluguel();                
		                    break;
		                    
		                case "13":
		                	menuBuilder.exibirHistoricoAluguelMidia(midia);          
		                    break;

		                case "14":
		                	menuBuilder.vender(cliente, midia);          
		                    break;
		                    
		                case "15":
		                	menuBuilder.alugar(cliente, midia);                
		                    break;

		                case "0":
		                	continuar = finalizarPrograma();
		                    break;
		                default:
		                    System.out.printf("Você digitou uma opção inválida.");
		                    System.lineSeparator();
		            }
	            }catch(Exception ex){
		        	System.err.println(quebraLinha+"LOG DE ERRO: "+ex.getMessage());
		        }
	        } while( continuar );  
	        
	    }

		public static boolean finalizarPrograma() {
			boolean continuar;
			continuar = false;
			System.out.println("Programa finalizado.");
			return continuar;
		}
		
		public static boolean voltarPrograma() {
			boolean continuar;
			continuar = false;
			System.out.println("Voltou...");
			return continuar;
		}
}
