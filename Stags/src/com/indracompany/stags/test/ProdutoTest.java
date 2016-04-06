package com.indracompany.stags.test;

import com.indracompany.stags.bo.ProdutoBO;
import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public class ProdutoTest {

	private static IProdutoBO produtoBO;

	static {
		produtoBO = new ProdutoBO();
	}

	public void inserir() throws Exception {
//		ProdutoModel produto1 = new ProdutoModel("produto1", 100, true, true, 10, TipoProduto.BLURAY);
//		ProdutoModel produto2 = new ProdutoModel("produto2", 40, true, true, 10, TipoProduto.DVD);
//		ProdutoModel produto3 = new ProdutoModel("produto3", 30, true, true, 100, TipoProduto.STREAM);

	}

	public void editar() throws Exception {

	}

	public void excluir() throws Exception {

	}

	public void listar() throws Exception {

	}

	public ProdutoModel buscar(Long codProduto) throws Exception {
		return null;
	}

	public void vender() throws Exception {

	}

	public void alugar(Long codProduto, Integer quantidade) throws Exception {

	}

}