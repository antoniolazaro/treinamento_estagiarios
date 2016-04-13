package com.indracompany.stags.view;

import java.util.List;
import java.util.Scanner;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ab.IClienteBO;
import com.indracompany.stags.model.ClienteModel;

public class MenuBuilder {

	IClienteBO clienteBo = new ClienteBO();

	public String executarMenuInicial() {

		System.out.println("\t\tMenu de opções:");
		System.out.println("\t1. Adicionar Cliente");
		System.out.println("\t2. Buscar Cliente");
		System.out.println("\t3.  Excluir Cliente");
		System.out.println("\t4. Editar contato");
		System.out.println("\t5. listar clientes");
		// add_maisopções
		System.out.println("\t0. Sair");

		return pedirEntrada("\nInsira sua opção: ");
	}

	public void inserirCliente() throws Exception {

		String nome = pedirEntrada("Digite o nome:");
		ClienteModel cliente = new ClienteModel();
		cliente.setNome(nome);
		clienteBo.inserir(cliente);

	}

	public void buscarCliente() throws Exception {
		String nome;
		nome = pedirEntrada("Digite o nome.");

		ClienteModel busca = clienteBo.buscar(nome);
		System.out.println("Nome = " + busca.getNome());
		System.out.println("Situação = " + busca.getAtivo());
		System.out.println("Código = " + busca.getCodigo());
	}

	public void excluirCliente() throws Exception {
		String nomeExcluir = pedirEntrada("\n Digite o Nome: ");

		clienteBo.excluir(nomeExcluir);
	}

	public void editarCliente() throws Exception {

		boolean cotinuar = true;

		do {

			String nome;
			String nomeAtualizar;
			nome = pedirEntrada("Digite o nome do Cliente:");
			nomeAtualizar = pedirEntrada("Digite o nome para atualizar");
			clienteBo.editar(nome, nomeAtualizar);
			String opcao = pedirEntrada("Digite 1 para continuar ou 0 para sair");
			if (opcao.equals(0)) {
				cotinuar = false;
			}

		} while (cotinuar);

	}

	public void listarCliente() throws Exception {
		List<ClienteModel> listagem = clienteBo.listar();
		for (ClienteModel clienteModel : listagem) {
			System.out.println(clienteModel.getNome());
			System.out.println(clienteModel.getAtivo());
			System.out.println(clienteModel.getCodigo());
			System.out.println();
			System.out.println();
		}

	}

	public String pedirEntrada(String mensagemEntrada) {
		Scanner entrada = new Scanner(System.in);
		System.out.print(mensagemEntrada);
		return entrada.nextLine();
	}

}