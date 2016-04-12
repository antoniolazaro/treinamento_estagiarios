package com.indracompany.stags.test;

import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ab.IClienteBO;
import com.indracompany.stags.model.ClienteModel;

public class ClienteTest {

	private static IClienteBO clienteBO;
	private static ClienteModel lCliente1;
	private static ClienteModel lCliente2;
	private static ClienteModel lCliente3;
	private static ClienteModel lClient4;
	private static ClienteModel lCliente5;
	static {
		clienteBO = new ClienteBO();

		lCliente1 = new ClienteModel();
		lCliente1.setNome("Antônio Visionário");

		lCliente2 = new ClienteModel();
		lCliente2.setNome("Luis Cardoso");

		lCliente3 = new ClienteModel();
		lCliente3.setNome("Caio");

		lClient4 = new ClienteModel();
		lClient4.setNome("Karen");

		lCliente5 = new ClienteModel();
		lCliente5.setNome("Matheus");
	}

	public static void inserirCliente() throws Exception {

		clienteBO.inserir(lCliente1);
		clienteBO.inserir(lCliente2);
		clienteBO.inserir(lCliente3);
		clienteBO.inserir(lClient4);
		clienteBO.inserir(lCliente5);

	}

	public static void excluirCliente() throws Exception {

		clienteBO.excluir(lCliente1);
		clienteBO.excluir(lCliente2);
		clienteBO.excluir(lCliente3);
	}

	public static void editarCliente() throws Exception {
		ClienteModel lCliente = new ClienteModel();
		lCliente.setCodigo(2L);

		ClienteModel lClienteBusca = clienteBO.buscar(lCliente);

		if (lClienteBusca != null) {
			lClienteBusca.setNome("Luis de Jah");
			clienteBO.editar(lClienteBusca);
		}
	}

	public static void exibirCliente() throws Exception {
		System.out.println("*******************************************************");
		List<ClienteModel> lListaCliente = clienteBO.listar();
		if (lListaCliente != null && lListaCliente.size() > 0) {
			for (ClienteModel lCliente : lListaCliente) {
				System.out.println(lCliente);
			}
		}
	}

	public static void main(String[] args) {
		try {
			inserirCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			editarCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			exibirCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			excluirCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			exibirCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}