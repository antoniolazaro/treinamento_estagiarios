package com.indracompany.stags.bo;

import java.util.Collection;

import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.memory.ProdutoDaoMemory;
import com.indracompany.stags.model.ClienteModel;
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
		if (pModel == null) {
			throw new Exception("Produto nulo");

		} else if (pModel.getNome().equals("")) {
			throw new Exception("Nome Obrigatorio");

		} else if (pModel.getPrecoAluguel() <= 0 || pModel.getPrecoVenda() <= 0) {
			throw new Exception("Os valores devem ser maiores que zero");
		} else if (pModel.getQuantidade() <= 0) {
			throw new Exception("Quantidade Invalida");

		}
	}

	public TipoProduto validarTipoProduto(String tipo) throws Exception {
		TipoProduto tipoProduto = null;

		if (tipo.equalsIgnoreCase("dvd")) {
			tipoProduto = TipoProduto.DVD;
		} else if (tipo.equalsIgnoreCase("bluray")) {
			tipoProduto = TipoProduto.BLURAY;

		} else if (tipo.equalsIgnoreCase("stream")) {
			tipoProduto = TipoProduto.STREAM;

		} else {
			throw new Exception("Tipo inválido");
		}
		return tipoProduto;
	}

	private void validateList(Collection<ProdutoModel> lista) throws Exception {
		if (lista == null) {
			throw new Exception("Lista Vazia");
		}
	}

	private void validateBusca(ProdutoModel produto) throws Exception {
		if (produto == null) {
			throw new Exception("Produto  Não Existe!");
		}
	}

	public void tratarSituacaoProduto(ProdutoModel produto) {
		if (produto.getAtivo() == true) {
			System.out.println("Situação: Ativo");
		} else {
			System.out.println("Situação inativo");
		}
	}

}