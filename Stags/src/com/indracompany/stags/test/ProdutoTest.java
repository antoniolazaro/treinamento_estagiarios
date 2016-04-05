package com.indracompany.stags.test;

import com.indracompany.stags.bo.ProdutoBO;
import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public class ProdutoTest {
	public static void main(String[] args) {

		IProdutoBO iProdutoBO = new ProdutoBO();
		ProdutoModel produto1 = new ProdutoModel("produto1", 10, true, true, 50, TipoProduto.DVD);
		ProdutoModel produto2 = new ProdutoModel("produto2", 10, true, true, 50, TipoProduto.BLURAY);
		try {
			iProdutoBO.inserir(produto1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			iProdutoBO.inserir(produto2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}