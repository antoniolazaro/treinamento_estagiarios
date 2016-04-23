package com.indracompany.stags.bo;

import java.util.Collection;

import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.memory.ProdutoDaoMemory;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public class ProdutoBO implements IProdutoBO {

	private IProdutoDao produtoDaoMemory;

	public ProdutoBO() {

		this.produtoDaoMemory = new ProdutoDaoMemory();
	}

	public void inserir(ProdutoModel pModel) throws Exception {
		validate(pModel);
		produtoDaoMemory.inserir(pModel);
	}

	public void editar(ProdutoModel produto) throws Exception {
		validate(produto);
		produtoDaoMemory.editar(produto);
	}

	public void excluir(ProdutoModel produto) throws Exception {
		if (produto == null) {
			throw new Exception("produto nao encontrado");
		} else {
			produto.setAtivo(false);
			produtoDaoMemory.excluir(produto);
		}
	}

	public Collection<ProdutoModel> buscarPorNome(String nome) throws Exception {
		validateList(produtoDaoMemory.buscarPorNome(nome));
		return produtoDaoMemory.buscarPorNome(nome);
	}

	public ProdutoModel buscar(String nome) throws Exception {
		validateBusca(produtoDaoMemory.buscar(nome));
		return produtoDaoMemory.buscar(nome);
	}

	private void validate(ProdutoModel pModel) throws Exception {

		if (pModel != null) {
			if (pModel.getNome().equals(""))
				throw new Exception("Nome Obrigatorio");
			if (pModel.getPrecoVenda() <= 0)
				throw new Exception("Os valores devem ser maiores que zero");
			if (pModel.getPrecoAluguel() <= 0)
				throw new Exception("Os valores devem ser maiores que zero");
			if (pModel.getQuantidade() <= 0)
				throw new Exception("Quantidade Invalida");
		}
	}

	public TipoProduto validarTipoProduto(String tipo) throws Exception {
		TipoProduto tipoProduto = null;

		if (tipo.equalsIgnoreCase("a")) {
			tipoProduto = TipoProduto.DVD;
		} else if (tipo.equalsIgnoreCase("b")) {
			tipoProduto = TipoProduto.BLURAY;

		} else if (tipo.equalsIgnoreCase("c")) {
			tipoProduto = TipoProduto.STREAM;

		} else {
			throw new Exception("Tipo inválido");
		}
		return tipoProduto;
	}

	private void validateList(Collection<ProdutoModel> collection) throws Exception {
		if (collection.isEmpty()) {
			throw new Exception("Lista Vazia");
		}
	}

	private void validateBusca(ProdutoModel produto) throws Exception {
		if (produto == null)
			throw new Exception("Produto  Não Existe!");

	}

	private void validateBuscaCompra(ProdutoModel produto) throws Exception {
		if (produto.getQuantidade() <= 0) {
			throw new Exception("Quantidade Insuficiente");
		}
	}

	public void tratarSituacaoProduto(ProdutoModel produto) {
		if (produto.getAtivo() == true) {
			System.out.println("Situação: Ativo");
		} else {
			System.out.println("Situação: inativo");
		}
	}

	public ProdutoModel maisCaro() throws Exception {
		validateList(produtoDaoMemory.listaProduto());
		ProdutoModel produtoRetorno = new ProdutoModel();
		produtoRetorno.setPrecoVenda(0.0);
		for (ProdutoModel produto : produtoDaoMemory.listaProduto()) {
			if (produto.getPrecoVenda() > produtoRetorno.getPrecoVenda()) {
				produtoRetorno = produto;
			}
		}
		return produtoRetorno;
	}

	public ProdutoModel maisBarato() throws Exception {
		validateList(produtoDaoMemory.listaProduto());
		ProdutoModel produtoRetorno = new ProdutoModel();
		produtoRetorno.setPrecoVenda(9223372036854775807.0);
		for (ProdutoModel produto : produtoDaoMemory.listaProduto()) {
			if (produto.getPrecoVenda() < produtoRetorno.getPrecoVenda()) {
				produtoRetorno = produto;
			}
		}
		return produtoRetorno;
	}

}