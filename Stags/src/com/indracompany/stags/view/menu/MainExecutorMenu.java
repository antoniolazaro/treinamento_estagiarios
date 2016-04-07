package com.indracompany.stags.view.menu;

import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;

public class MainExecutorMenu {
		    
	    public static void main (String [] Args) throws Exception {
	    	String quebraLinha = System.getProperty("line.separator");
			boolean continuar=true;
	    	String opcao;
	        ClienteModel cliente = new ClienteModel(opcao, opcao, opcao);
	        MidiaModel midia = new MidiaModel(opcao, opcao, opcao, opcao, opcao, opcao, opcao);
	        MenuBuilder menuBuilder = new MenuBuilder();
	        do{
	            opcao = menuBuilder.executarMenuInicial();
	            
	            try{
		            switch( opcao )
		            {
		                case "1":
		                	menuBuilder.buscarCliente(ClienteModel cliente);
		                    break;        
		                    
		                case "2":
		                	menuBuilder.buscarMidia(MidiaModel midia);
		                    break;
		                    
//		                case "3":
//		                	menuBuilder.editarContato(agenda);	                   
//		                    break;
//		                    
//		                case "4":
//		                	menuBuilder.excluirContato(agenda);                  
//			                break;
//			            
//		                case "5":
//		                	menuBuilder.buscarContato(agenda);
//		                    break;
//		                    
//		                case "6":
//		                	menuBuilder.buscarContato(agenda);
//		                    break;
//		                    
//		                case "7":
//		                	menuBuilder.buscarContato(agenda);
//		                    break;
//		                    
//		                case "8":
//		                	menuBuilder.buscarContato(agenda);
//		                    break;
//		                    
//		                case "9":
//		                	menuBuilder.buscarContato(agenda);
//		                    break;
//		                    
//		                case "10":
//		                	menuBuilder.buscarContato(agenda);
//		                    break;
		                    
		                case "0":
		                	continuar = finalizarPrograma();
		                    break;
		                default:
		                    System.out.printf("Você digitou uma opção inválida.");
		                    System.lineSeparator();
		            }       
	            }catch(Exception ex){
	            	System.out.println("Erro -> "+ex.getMessage());
	            }
	        } while( continuar );  
	    }

		private static boolean finalizarPrograma() {
			boolean continuar;
			continuar = false;
			System.out.println("Programa finalizado.");
			return continuar;
		}
}
