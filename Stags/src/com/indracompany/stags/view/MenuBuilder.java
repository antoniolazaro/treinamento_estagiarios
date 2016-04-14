package com.indracompany.stags.view;

import java.util.Collection;

import java.util.List;

import java.util.Scanner;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ProdutoBO;
import com.indracompany.stags.bo.ab.IClienteBO;
import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public class MenuBuilder {

	IClienteBO clienteBo = new ClienteBO();
	IProdutoBO produtoBO = new ProdutoBO();
	static Scanner scanner = new Scanner(System.in);
	static String quebraLinha = System.lineSeparator();

	public String executarMenuInicial() {

		// cliente
		System.out.println("\t\tMenu de opções:" + "" + quebraLinha);
		System.out.println("Cliente" + quebraLinha);
		System.out.println("\t1. Adicionar Cliente");
		System.out.println("\t2. Buscar Cliente");
		System.out.println("\t3.  Excluir Cliente");
		System.out.println("\t4. Editar contato");
		System.out.println("\t5. listar clientes" + "" + quebraLinha);

		System.out.println("Produto" + quebraLinha);

		// produto
		System.out.println("\t6. Adicionar Produto");
		System.out.println("\t7. Buscar Produto");
		System.out.println("\t8. Excluir Produto");
		System.out.println("\t9. Editar Produto");
		// add_maisopções
		System.out.println("\t0. Sair" + quebraLinha);

		return pedirEntrada("\nInsira sua opção: ");
	}

	// cliente
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
		// String nomeExcluir = pedirEntrada("\n Digite o Nome: ");
		//
		// clienteBo.excluir(nomeExcluir);

		String nome = pedirEntrada("Digite o nome do cliente para excluir");
		ClienteModel cliente = clienteBo.buscar(nome);
		clienteBo.excluir(cliente);
	}

	public void editarCliente() throws Exception {

		boolean continuar = true;

		do {

			String nome;
			String nomeAtualizar;
			String opcao;
			nome = pedirEntrada("Digite o nome do Cliente:");
			nomeAtualizar = pedirEntrada("Digite o nome para atualizar");
			ClienteModel cliente = clienteBo.buscar(nome);
			cliente.setNome(nomeAtualizar);
			clienteBo.editar(cliente);
			opcao = pedirEntrada("Digite 1 para editar outro Cliente");
			if (!opcao.equals("1")) {
				continuar = false;

			}

		} while (continuar);

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

	// produto
	public void inserirProduto() throws Exception {

		String nome;
		Double precoVenda;
		Double precoAluguel;
		Integer quantidade;
		String tipoProduto;
		TipoProduto tipo;
		ProdutoModel produto = new ProdutoModel();

		nome = pedirEntrada("Digite o nome: ");
		precoVenda = pedirEntradaNumeroDouble("Digite o preço de venda: ");
		precoAluguel = pedirEntradaNumeroDouble("Digite o preço de aluguel: ");
		tipoProduto = pedirEntrada("Digite o tipo do produto DVD, BLURAY, STREAM: ");
		tipo = produtoBO.validarTipoProduto(tipoProduto);
		quantidade = pedirEntradaNumeroInteger("Digite a quantidade: ");

		produto.setNome(nome);
		produto.setPrecoVenda(precoVenda);
		produto.setPrecoAluguel(precoAluguel);
		produto.setTipoProduto(tipo);
		produto.setQuantidade(quantidade);

		produtoBO.inserir(produto);

	}

	public void buscarProduto() throws Exception {
		String nome;
		nome = pedirEntrada("Digite o nome.");

		Collection<ProdutoModel> busca = produtoBO.buscarPorNome(nome);
		for (ProdutoModel produtoModel : busca) {
			System.out.println("Codigo: " + produtoModel.getCodigo());
			System.out.println("Nome: " + produtoModel.getNome());
			System.out.println("Preço Venda: " + produtoModel.getPrecoVenda());
			System.out.println("Preço Aluguel: " + produtoModel.getPrecoAluguel());
			System.out.println("Tipo: " + produtoModel.getTipoProduto().toString() + quebraLinha);

		}

	}

	public void editarProduto() throws Exception {
		boolean continuar = true;
		do {
			String opcao;
			String nome;
			String nomeAtualizar;
			Double precoVenda;
			Double precoAluguel;
			Integer quantidade;

			nome = pedirEntrada("Digite o nome: ");
			ProdutoModel produto = produtoBO.buscar(nome);
			nomeAtualizar = pedirEntrada("Novo Nome : ");
			precoVenda = pedirEntradaNumeroDouble("Digite o valor de venda: ");
			precoAluguel = pedirEntradaNumeroDouble("Digite o valor de aluguel: ");
			quantidade = pedirEntradaNumeroInteger("Digite a quantidade: ");
			produto.setNome(nomeAtualizar);
			produto.setPrecoAluguel(precoAluguel);
			produto.setPrecoVenda(precoVenda);
			produto.setQuantidade(quantidade);
			produtoBO.editar(produto);

			opcao = pedirEntrada("Digite 1 para editar outro Produto");
			if (!opcao.equals("1")) {
				continuar = false;

			}

		} while (continuar);

	}

	public void excluirProduto() throws Exception {

		String nomeProduto = pedirEntrada("Digite o nome do produto: ");
		ProdutoModel produto = produtoBO.buscar(nomeProduto);

		produtoBO.excluir(produto);
	}

	public String pedirEntrada(String mensagemEntrada) {
		System.out.print(mensagemEntrada);
		return scanner.next();
	}

	public double pedirEntradaNumeroDouble(String mensagemEntrada) {
		System.out.print(mensagemEntrada);
		return scanner.nextDouble();
	}

	public Integer pedirEntradaNumeroInteger(String mensagemEntrada) {
		System.out.print(mensagemEntrada);
		return scanner.nextInt();
	}

}