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
		produto2 = new ProdutoModel("produto2", 40.0, 10.0, 10, TipoProduto.STREAM);
		produto3 = new ProdutoModel("produto3", 20.0, 6.0, 10, TipoProduto.DVD);
	}

	public static void inserir() throws Exception {

		produtoBO.inserir(produto1);
		produtoBO.inserir(produto2);
		produtoBO.inserir(produto3);

	}

	public static void editar() throws Exception {

		produto1.setNome("produtoUm");
		produtoBO.editar(produto1);
	}

	public static void excluir() throws Exception {
		produtoBO.excluir(produto3);
	}

	public static void buscarPorNome() throws Exception {
		for (ProdutoModel produtoModel : produtoBO.buscarPorNome("prod")) {
			System.out.println(produtoModel.getNome());
			System.out.println(produtoModel.getPrecoVenda());
			System.out.println(produtoModel.getPrecoAluguel());

		}
	}

	public static void buscar() throws Exception {

		ProdutoModel produto = produtoBO.buscar(produto2);

		System.out.println(produto.getNome());
		System.out.println(produto.getPrecoVenda());
		System.out.println(produto.getPrecoAluguel());
		System.out.println(produto.getQuantidade());
		System.out.println(produto.getTipoProduto());
	}

	public static void main(String[] args) {
		try {
			inserir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			buscarPorNome();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			editar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		try {
			buscar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			excluir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			buscarPorNome();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}