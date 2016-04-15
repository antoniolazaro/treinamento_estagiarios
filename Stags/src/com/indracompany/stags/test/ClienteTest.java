package com.indracompany.stags.test;

import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.model.ClienteModel;

public class ClienteTest {
	
	private static ClienteBOIf clienteBO;
	
	static{
		clienteBO = new ClienteBO();
	}
		
	public void inserirCliente() throws Exception{
		
		ClienteModel lCliente1 = new ClienteModel();
		lCliente1.setNome("Antônio Visionário");
		lCliente1.setCodigo((long) 1);
		lCliente1.setIdade(25);
		lCliente1.setCpf("7364736435246");
		lCliente1.setAtivo(true);
		
		ClienteModel lCliente2 = new ClienteModel();
		lCliente2.setNome("Luis Cardoso");
		lCliente2.setCodigo((long) 2);
		lCliente2.setIdade(45);
		lCliente2.setCpf("7364736435236");
		lCliente2.setAtivo(true);
		
		ClienteModel lCliente3 = new ClienteModel();
		lCliente3.setNome("Caio");
		lCliente3.setCodigo((long) 3);
		lCliente3.setIdade(23);
		lCliente3.setCpf("7364736433236");
		lCliente3.setAtivo(true);
		
		ClienteModel lCliente4 = new ClienteModel();
		lCliente4.setNome("Karen");
		lCliente4.setCodigo((long) 4);
		lCliente4.setIdade(24);
		lCliente4.setCpf("7363336433236");
		lCliente4.setAtivo(true);
		
		ClienteModel lCliente5 = new ClienteModel();
		lCliente5.setNome("Matheus");
		lCliente5.setCodigo((long) 5);
		lCliente5.setIdade(24);
		lCliente5.setCpf("1264736433236");
		lCliente5.setAtivo(true);
		
		clienteBO.inserir(lCliente1);
		clienteBO.inserir(lCliente2);
		clienteBO.inserir(lCliente3);
		clienteBO.inserir(lCliente4);
		clienteBO.inserir(lCliente5);
		
	}
	
	public void excluirCliente() throws Exception{
		ClienteModel lCliente = new ClienteModel();
		lCliente.setCodigo(2L);
		
		clienteBO.excluir(lCliente);
	}
	
	
	public void editarCliente() throws Exception{
		ClienteModel lCliente = new ClienteModel();
		lCliente.setCodigo(2L);		
		
		ClienteModel lClienteBusca = clienteBO.buscar(lCliente);
		
		if(lClienteBusca !=null){
			lClienteBusca.setNome("Luis de Jah");
			clienteBO.editar(lClienteBusca);
		}
	}
	
	public void buscarCliente() throws Exception{		
		clienteBO.buscarCliente("Antônio");		
		clienteBO.buscarCliente("Caio");		
		clienteBO.buscarCliente("Karen");		
		clienteBO.buscarCliente("Matheus");
	}
	
	public void exibirCliente()throws Exception{
		System.out.println("*******************************************************");
		List<ClienteModel> lListaCliente = clienteBO.listar();
		if(lListaCliente !=null && lListaCliente.size() > 0){
			for(ClienteModel lCliente:lListaCliente){
				System.out.println(lCliente);
			}
		}
	}
}
