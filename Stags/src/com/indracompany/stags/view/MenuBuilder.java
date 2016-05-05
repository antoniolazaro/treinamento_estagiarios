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
		System.out.println("\t5. Reativar Cliente");
		System.out.println("\t6. listar Clientes" + "" + QUEBRA_LINHA);

		System.out.println("Produto:" + QUEBRA_LINHA);

		// produto
		System.out.println("\t7. Adicionar Produto");
		System.out.println("\t8. Buscar Produto");
		System.out.println("\t9. Excluir Produto");
		System.out.println("\t10. Editar Produto" + QUEBRA_LINHA);
		// compras
		System.out.println("Compras:" + QUEBRA_LINHA);
		System.out.println("\t11. Comprar");
		System.out.println("\t12. Alugar");
		System.out.println("\t13 Listar Compras");
		// parte 4
		System.out.println("Parte 4" + QUEBRA_LINHA);
		System.out.println("\t14 Produto mais caro");
		System.out.println("\t15 Produto mais barato");
		System.out.println("\t16 Media de preço");
		System.out.println("\t17 Buscar Produto por Código");
		System.out.println("\t18 Média de Aluguel");

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
		nome = pedirEntrada("Digite o nome:");
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
			nomeAtualizar = pedirEntrada("Digite o nome para atualizar: ");
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
			System.out.println("Nome: " + clienteModel.getNome());
			clienteBo.tratarSituacaoCliente(clienteModel);
			System.out.println("Código: " + clienteModel.getCodigo());
			System.out.println();
			System.out.println();
		}

	}

	public void reativarCliente() throws Exception {
		String nome;
		ClienteModel cliente;
		nome = pedirEntrada("Digite o nome do cliente para reativar: ");
		cliente = clienteBo.buscar(nome);
		clienteBo.reativarCliente(cliente);
		System.out.println("Cliente reativado!");
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
		precoVenda = pedirEntradaNumeroDouble("Digite o preço de venda somente números: ");
		precoAluguel = pedirEntradaNumeroDouble("Digite o preço de aluguel somente números: ");
		tipoProduto = pedirEntrada("Digite o tipo do produto a-> DVD, b-> BLURAY, c-> STREAM: ");
		tipo = produtoBO.validarTipoProduto(tipoProduto);
		quantidade = pedirEntradaNumeroInteger("Digite a quantidade somente números: ");

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
		nome = pedirEntrada("Digite o nome: ");

		Collection<ProdutoModel> busca = produtoBO.buscarPorNome(nome);
		System.out.println("Produtos: ");
		for (ProdutoModel produtoModel : busca) {
			System.out.println("Codigo: " + produtoModel.getCodigo());
			System.out.println("Nome: " + produtoModel.getNome());
			System.out.println("Preço Venda: " + produtoModel.getPrecoVenda());
			System.out.println("Preço Aluguel: " + produtoModel.getPrecoAluguel());
			System.out.println("Quantidade: " + produtoModel.getQuantidade());
			System.out.print("Situação: ");
			produtoBO.tratarSituacaoProduto(produtoModel);
			System.out.println("Tipo: " + produtoModel.getTipoProduto().toString());
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
			String tipoProduto;
			TipoProduto tipo;

			nome = pedirEntrada("Digite o nome: ");
			ProdutoModel produto = produtoBO.buscar(nome);
			nomeAtualizar = pedirEntrada("Novo Nome : ");
			precoVenda = pedirEntradaNumeroDouble("Digite o valor de venda somente números:");
			precoAluguel = pedirEntradaNumeroDouble("Digite o valor de aluguel Somente números:");
			quantidade = pedirEntradaNumeroInteger("Digite a quantidade Somente números: ");
			tipoProduto = pedirEntrada("Digite o tipo do produto a-> DVD, b-> BLURAY, c-> STREAM: ");
			tipo = produtoBO.validarTipoProduto(tipoProduto);

			produto.setNome(nomeAtualizar);
			produto.setPrecoAluguel(precoAluguel);
			produto.setPrecoVenda(precoVenda);
			produto.setQuantidade(quantidade);
			produto.setTipoProduto(tipo);
			produtoBO.editar(produto);
			System.out.println("Produto Editado Com sucesso!");
			opcao = pedirEntrada("Digite S para editar outro ou qualquer outra letra para cancelar a Edição");
			if (!opcao.equalsIgnoreCase("s")) {
				continuar = false;

			}

		} while (continuar);

	}

	public void excluirProduto() throws Exception {

		String nomeProduto = pedirEntrada("Digite o nome do produto: ");
		ProdutoModel produto = produtoBO.buscar(nomeProduto);
		produtoBO.excluir(produto);
		System.out.println("Produto Excluido com sucesso! ");
	}

	// compra

	public void comprar() throws Exception {
		boolean continuar = true;
		String nomeCliente;
		ClienteModel cliente;
		CompraModel compra = new CompraModel();
		nomeCliente = pedirEntrada("Digite o nome do cliente");
		cliente = clienteBo.buscar(nomeCliente);
		if (cliente.getAtivo() == false) {
			throw new Exception("Cliente inativo!");
		}
		compra.setClienteModel(cliente);
		compra.setDias(1);
		compra.setTipoCompra(TipoCompra.COMPRA);

		do {

			String opcao;
			String nome;
			ProdutoModel produto;
			nome = pedirEntrada("Digite o nome do produto: ");
			produto = produtoBO.buscar(nome);
			if (produto.getQuantidade() == 0) {
				throw new Exception("Produto com quantidade insuficiente!");
			}
			compraBO.addlistaProduto(produto, compra);
			opcao = pedirEntrada("Digite S para add outro ou qualquer outra letra para cancelar a Edição");
			if (!opcao.equalsIgnoreCase("s")) {
				continuar = false;

			}
		} while (continuar);
		compraBO.vender(compra);
		System.out.println("Compra realizada com sucesso!");
	}

	public void alugar() throws Exception {
		boolean continuar = true;
		String nomeCliente;
		ClienteModel cliente;
		Integer dias = 1;
		CompraModel compra = new CompraModel();
		nomeCliente = pedirEntrada("Digite o nome do cliente: ");
		cliente = clienteBo.buscar(nomeCliente);
		if (cliente.getAtivo() == false) {
			throw new Exception("Cliente inativo!");
		}
		compra.setClienteModel(cliente);
		compra.setTipoCompra(TipoCompra.ALUGUEL);

		do {

			String opcao;
			String nome;
			ProdutoModel produto;
			nome = pedirEntrada("Digite o nome do produto: ");
			produto = produtoBO.buscar(nome);
			if (produto.getQuantidade() == 0) {
				throw new Exception("Produto com quantidade insuficiente!");
			}
			compraBO.addlistaProduto(produto, compra);
			opcao = pedirEntrada("Digite S para add outro ou qualquer outra letra para cancelar a Edição");
			if (!opcao.equalsIgnoreCase("s")) {
				continuar = false;

			}
		} while (continuar);
		dias = pedirEntradaNumeroInteger("Digite os dias para aluguel: ");
		compra.setDias(dias);
		compraBO.alugar(compra);
		System.out.println("você realizou a transação com sucesso!");
	}

	public void listarCompras() throws Exception {
		for (CompraModel compra : compraBO.listar()) {
			System.out.println("Cliente: " + compra.getClienteModel().getNome() + " Código  do cliente: "
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
			System.out.println("************************************************************");
		}
	}

	private String pedirEntrada(String mensagemEntrada) {
		System.out.print(mensagemEntrada);
		return scanner.next();
	}

	private Double pedirEntradaNumeroDouble(String mensagemEntrada) {
		Double retorno = null;
		while (retorno == null) {
			System.out.print(mensagemEntrada);
			retorno = validarDouble(scanner.next());
		}
		return retorno;
	}

	private Integer pedirEntradaNumeroInteger(String mensagemEntrada) {

		Integer retorno = null;
		while (retorno == null) {
			System.out.print(mensagemEntrada);
			retorno = validarInteger(scanner.next());
		}
		return retorno;
	}

	private Long pedirEntradaNumeroLong(String mensagemEntrada) {

		Long retorno = null;
		while (retorno == null) {
			System.out.print(mensagemEntrada);
			retorno = validarLong(scanner.next());
		}
		return retorno;
	}

	private Double validarDouble(String numero) {
		try {
			return Double.parseDouble(numero);
		} catch (Exception e) {

			return null;
		}
	}

	private Integer validarInteger(String numero) {
		try {
			return Integer.parseInt(numero);
		} catch (Exception e) {

			return null;
		}
	}

	private Long validarLong(String numero) {
		try {
			return Long.parseLong(numero);
		} catch (Exception e) {

			return null;
		}
	}

	// parte 4
	public void prudutoMaisCaro() throws Exception {
		ProdutoModel produto;

		produto = produtoBO.maisCaro();
		System.out.print(QUEBRA_LINHA);
		System.out.println("Código: " + produto.getCodigo());
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Preço Venda: " + produto.getPrecoVenda());
	}

	public void prudutoMaisBarato() throws Exception {
		ProdutoModel produto;

		produto = produtoBO.maisBarato();
		System.out.print(QUEBRA_LINHA);
		System.out.println("Código: " + produto.getCodigo());
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Preço Venda: " + produto.getPrecoVenda());
	}

	public void mediaPreco() throws Exception {
		System.out.println("Amédia de preço dos produtos é = " + produtoBO.calcularMedia());
	}

	public void buscarProdutoCodigo() throws Exception {
		Long codigo;

		ProdutoModel produtoPesquisa;

		codigo = pedirEntradaNumeroLong("Digite o codigo: ");
		ProdutoModel produto = new ProdutoModel();
		produto.setCodigo(codigo);
		produtoPesquisa = produtoBO.buscarPorCodigo(produto);
		System.out.println("**************************************************");
		System.out.println("Nome: " + produtoPesquisa.getNome());
		System.out.println("Preço Venda: " + produtoPesquisa.getPrecoVenda());
		System.out.println("Preço Alguel: " + produtoPesquisa.getPrecoAluguel());
		System.out.println("Tipo: " + produtoPesquisa.getTipoProduto().toString());
		System.out.println("Quantidade: " + produtoPesquisa.getQuantidade());
		System.out.println("**************************************************");
	}

	public void calcularMediaAlguel() throws Exception {
		System.out.println("Amédia de preço dos produtos é = " + produtoBO.calcularMediaAluguel());

	}

}