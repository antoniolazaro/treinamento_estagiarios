package com.indracompany.stags.view;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.CompraBO;
import com.indracompany.stags.bo.ProdutoBO;
import com.indracompany.stags.bo.ab.IClienteBO;
import com.indracompany.stags.bo.ab.ICompraBO;
import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoCompra;
import com.indracompany.stags.model.TipoProduto;

public class MenuBuilder {

	IClienteBO clienteBo = new ClienteBO();
	IProdutoBO produtoBO = new ProdutoBO();
	ICompraBO compraBO = new CompraBO();
	static Scanner scanner = new Scanner(System.in);
	final static String QUEBRA_LINHA = System.lineSeparator();

	public String executarMenuInicial() {

		// cliente
		System.out.println("\t\tMenu de opções:" + "" + QUEBRA_LINHA);
		System.out.println("Cliente:" + QUEBRA_LINHA);
		System.out.println("\t1. Adicionar Cliente");
		System.out.println("\t2. Buscar Cliente");
		System.out.println("\t3. Excluir Cliente");
		System.out.println("\t4. Editar Cliente");
		System.out.println("\t5. listar Clientes" + "" + QUEBRA_LINHA);

		System.out.println("Produto:" + QUEBRA_LINHA);

		// produto
		System.out.println("\t6. Adicionar Produto");
		System.out.println("\t7. Buscar Produto");
		System.out.println("\t8. Excluir Produto");
		System.out.println("\t9. Editar Produto" + QUEBRA_LINHA);

		System.out.println("Compras:" + QUEBRA_LINHA);
		System.out.println("\t10. Comprar");
		System.out.println("\t11. Alugar");
		System.out.println("\t13 Listar Compras");
		// add_maisopções

		System.out.println("\t0. Sair" + QUEBRA_LINHA);

		return pedirEntrada("\nInsira sua opção: ");
	}

	// cliente
	public void inserirCliente() throws Exception {

		String nome = pedirEntrada("Digite o nome:");
		ClienteModel cliente = new ClienteModel();
		cliente.setNome(nome);
		clienteBo.inserir(cliente);
		System.out.println("Cliente Inserido com sucesso");

	}

	public void buscarCliente() throws Exception {
		String nome;
		nome = pedirEntrada("Digite o nome.");
		System.out.println("Clientes: " + QUEBRA_LINHA);
		ClienteModel busca = clienteBo.buscar(nome);
		System.out.println("Nome: " + busca.getNome());
		clienteBo.tratarSituacaoCliente(busca);
		System.out.println("Código: " + busca.getCodigo());
	}

	public void excluirCliente() throws Exception {
		// String nomeExcluir = pedirEntrada("\n Digite o Nome: ");
		//
		// clienteBo.excluir(nomeExcluir);

		String nome = pedirEntrada("Digite o nome do cliente para excluir:");
		ClienteModel cliente = clienteBo.buscar(nome);
		clienteBo.excluir(cliente);
		System.out.println("Cliente excluido com sucesso!");
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
			System.out.println("Cliente Editado com sucesso!");
			opcao = pedirEntrada("Digite 1 para editar outro Cliente ou outra tecla para cancelar a edição");
			if (!opcao.equals("1")) {
				continuar = false;

			}

		} while (continuar);

	}

	public void listarCliente() throws Exception {
		List<ClienteModel> listagem = clienteBo.listar();
		System.out.println("Clientes: ");
		for (ClienteModel clienteModel : listagem) {
			System.out.println(clienteModel.getNome());
			clienteBo.tratarSituacaoCliente(clienteModel);
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
		tipoProduto = pedirEntrada("Digite o tipo do produto a-> DVD, b-> BLURAY, c-> STREAM: ");
		tipo = produtoBO.validarTipoProduto(tipoProduto);
		quantidade = pedirEntradaNumeroInteger("Digite a quantidade: ");

		produto.setNome(nome);
		produto.setPrecoVenda(precoVenda);
		produto.setPrecoAluguel(precoAluguel);
		produto.setTipoProduto(tipo);
		produto.setQuantidade(quantidade);

		produtoBO.inserir(produto);
		System.out.println("Produto Inserido Com sucesso!");
	}

	public void buscarProduto() throws Exception {
		String nome;
		nome = pedirEntrada("Digite o nome.");

		Collection<ProdutoModel> busca = produtoBO.buscarPorNome(nome);
		System.out.println("Produtos: ");
		for (ProdutoModel produtoModel : busca) {
			System.out.println("Codigo: " + produtoModel.getCodigo());
			System.out.println("Nome: " + produtoModel.getNome());
			System.out.println("Preço Venda: " + produtoModel.getPrecoVenda());
			System.out.println("Preço Aluguel: " + produtoModel.getPrecoAluguel());
			System.out.print("Tipo: ");
			produtoBO.tratarSituacaoProduto(produtoModel);
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
			System.out.println("Produto Editado Com sucesso!");
			opcao = pedirEntrada("Digite 1 para editar outro ou qualquer outra tecla para cancelar a Edição");
			if (!opcao.equals("1")) {
				continuar = false;

			}

		} while (continuar);

	}

	public void excluirProduto() throws Exception {

		String nomeProduto = pedirEntrada("Digite o nome do produto: ");
		ProdutoModel produto = produtoBO.buscar(nomeProduto);

		produtoBO.excluir(produto);
		System.out.println("Produto Excluir: ");
	}

	// compra

	public void comprar() throws Exception {
		boolean continuar = true;
		String nomeCliente;
		ClienteModel cliente;
		CompraModel compra = new CompraModel();
		nomeCliente = pedirEntrada("Digite o nome do cliente");
		cliente = clienteBo.buscar(nomeCliente);
		compra.setClienteModel(cliente);
		compra.setDias(1);
		compra.setTipoCompra(TipoCompra.COMPRA);

		do {

			String opcao;
			String nome;
			ProdutoModel produto;
			nome = pedirEntrada("Digite o nome do produto");
			produto = produtoBO.buscar(nome);
			compraBO.addlistaProduto(produto, compra);
			opcao = pedirEntrada(
					"Digite um para add outro produto na lista ou qualquer " + "outra tecla para terminar a compra");
			if (!opcao.equals("1")) {
				continuar = false;

			}
		} while (continuar);
		compraBO.vender(compra);
	}

	public void alugar() throws Exception {
		boolean continuar = true;
		String nomeCliente;
		ClienteModel cliente;
		Integer dias = 1;
		CompraModel compra = new CompraModel();
		nomeCliente = pedirEntrada("Digite o nome do cliente");
		cliente = clienteBo.buscar(nomeCliente);
		compra.setClienteModel(cliente);
		compra.setTipoCompra(TipoCompra.ALUGUEL);

		do {

			String opcao;
			String nome;
			ProdutoModel produto;
			nome = pedirEntrada("Digite o nome do produto");
			produto = produtoBO.buscar(nome);
			compraBO.addlistaProduto(produto, compra);
			opcao = pedirEntrada(
					"Digite um para add outro produto na lista ou qualquer " + "outra tecla para terminar a compra");
			if (!opcao.equals("1")) {
				continuar = false;

			}
		} while (continuar);
		dias = pedirEntradaNumeroInteger("Digite os dias para aluguel");
		compra.setDias(dias);
		compraBO.alugar(compra);
	}

	public void listarCompras() {
		for (CompraModel compra : compraBO.listar()) {
			System.out.println("Cliente : " + compra.getClienteModel().getNome() + " Código  do cliente: "
					+ compra.getClienteModel().getCodigo());
			System.out.println(compra.getDataCompra());
			System.out.println("Produtos:" + QUEBRA_LINHA);
			for (ProdutoModel produto : compra.getListaProduto()) {
				System.out.println("Nome: " + produto.getNome());
				System.out.println("Preço de Venda: " + produto.getPrecoVenda());
				System.out.println("Preço de Aluguel: " + produto.getPrecoAluguel() + QUEBRA_LINHA);
			}
			System.out.println("Valor: " + compra.getValorTotal());
			System.out.println("Tipo: " + compra.getTipoCompra().toString() + QUEBRA_LINHA);
		}
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