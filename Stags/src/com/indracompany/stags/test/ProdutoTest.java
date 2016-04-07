package com.indracompany.stags.test;

import com.indracompany.stags.bo.ProdutoBO;

import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public class ProdutoTest {

	private static IProdutoBO produtoBO;
	static ProdutoModel produto1;
	static ProdutoModel produto2;
	static ProdutoModel produto3;

	static {
		produtoBO = new ProdutoBO();
		produto1 = new ProdutoModel("produto1", 100.0, 15.0, 10, TipoProduto.BLURAY);
		produto2 = new ProdutoModel("prdoduto2", 40.0, 10.0, 10, TipoProduto.STREAM);
		produto3 = new ProdutoModel("prdoduto3", 20.0, 6.0, 10, TipoProduto.DVD);
	}

	public void inserir() throws Exception {

		produtoBO.inserir(produto1);
		produtoBO.inserir(produto2);
		produtoBO.inserir(produto3);

	}

	public void editar() throws Exception {

		produto1.setNome("produtoUm");
		produtoBO.editar(produto1);
	}

	public void excluir() throws Exception {
		produtoBO.excluir(produto3);
	}

	public void listar() throws Exception {

		for (ProdutoModel produto : produtoBO.listar()) {
			if (produto.getAtivo()) {
				System.out.println(produto.getNome());
				System.out.println(produto.getPrecoVenda());
				System.out.println(produto.getPrecoAluguel());
				System.out.println(produto.getQuantidade());
				System.out.println(produto.getTipoProduto());
			}

		}
	}

	public void buscar() throws Exception {

		ProdutoModel produto = produtoBO.buscar(produto2);
		if (produto.getAtivo()) {

			System.out.println(produto.getNome());
			System.out.println(produto.getPrecoVenda());
			System.out.println(produto.getPrecoAluguel());
			System.out.println(produto.getQuantidade());
			System.out.println(produto.getTipoProduto());
		}
	}

}