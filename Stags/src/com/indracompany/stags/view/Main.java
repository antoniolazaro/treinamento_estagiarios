package com.indracompany.stags.view;

import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.model.ClienteModel;

public class Main {
	private static ClienteBOIf clienteBO;
	
	static{
		clienteBO = new ClienteBO();
	}
	
	public static void main(String[] args) {
		try {
//			inserirCliente();
//			exibirCliente();
			
//			inserirCliente();
//			exibirCliente();
//			excluirCliente();
//			exibirCliente();
//			
//			inserirCliente();
//			exibirCliente();
//			editarCliente();
//			exibirCliente();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void inserirCliente() throws Exception{
		
		ClienteModel lCliente1 = new ClienteModel(null, null, null, null, null);
		lCliente1.setNome("Antônio Visionário");		
		
		ClienteModel lCliente2 = new ClienteModel(null, null, null, null, null);
		lCliente2.setNome("Luis Cardoso");
		
		ClienteModel lCliente3 = new ClienteModel(null, null, null, null, null);
		lCliente3.setNome("Caio");
		
		ClienteModel lCliente4 = new ClienteModel(null, null, null, null, null);
		lCliente4.setNome("Karen");
		
		ClienteModel lCliente5 = new ClienteModel(null, null, null, null, null);
		lCliente5.setNome("Matheus");
		
		clienteBO.inserir(lCliente1);
		clienteBO.inserir(lCliente2);
		clienteBO.inserir(lCliente3);
		clienteBO.inserir(lCliente4);
		clienteBO.inserir(lCliente5);
		
	}
	
	public static void excluirCliente() throws Exception{
		ClienteModel lCliente = new ClienteModel(null, null, null, null, null);
		lCliente.setCodigo(2L);
		
		clienteBO.excluir(lCliente);
	}
	
	
	public static void editarCliente() throws Exception{
		ClienteModel lCliente = new ClienteModel(null, null, null, null, null);
		lCliente.setCodigo(2L);		
		
		ClienteModel lClienteBusca = clienteBO.buscar(lCliente);
		
		if(lClienteBusca !=null){
			lClienteBusca.setNome("Luis de Jah");
			clienteBO.editar(lClienteBusca);
		}
	}
	
	public static void exibirCliente()throws Exception{
		System.out.println("*******************************************************");
		List<ClienteModel> lListaCliente = clienteBO.listar();
		if(lListaCliente !=null && lListaCliente.size() > 0){
			for(ClienteModel lCliente:lListaCliente){
				System.out.println(lCliente);
			}
		}
	}
}
