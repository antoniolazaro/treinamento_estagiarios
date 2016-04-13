package com.indracompany.stags.bo;

import java.util.Collection;

import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.memory.ProdutoDaoMemory;
import com.indracompany.stags.model.ProdutoModel;

public class ProdutoBO implements IProdutoBO {

	private IProdutoDao produtoDaoMemory;

	public ProdutoBO() {

		this.produtoDaoMemory = new ProdutoDaoMemory();
	}

	public void inserir(ProdutoModel pModel) throws Exception {
		validate(pModel);
		produtoDaoMemory.inserir(pModel);
	}

	public void editar(String nome, String nomeAtualizar, Double precoVenda, Double precoAluguel, Integer quantidade)
			throws Exception {
		ProdutoModel produto = produtoDaoMemory.buscar(nome);
		produto.setNome(nomeAtualizar);
		produto.setPrecoAluguel(precoAluguel);
		produto.setPrecoVenda(precoVenda);
		produto.setQuantidade(quantidade);

		produtoDaoMemory.editar(produto);
	}

	public void excluir(String nome) throws Exception {
		ProdutoModel exclusao = produtoDaoMemory.buscar(nome);
		exclusao.setAtivo(false);
		produtoDaoMemory.excluir(exclusao);
	}

	public Collection<ProdutoModel> buscarPorNome(String nome) {

		return produtoDaoMemory.buscarPorNome(nome);
	}

	public ProdutoModel buscar(String nome) throws Exception {
		return produtoDaoMemory.buscar(nome);
	}

	private void validate(ProdutoModel pModel) throws Exception {
		if (pModel == null) {
			throw new Exception("Produto nulo");
		}
	}

}