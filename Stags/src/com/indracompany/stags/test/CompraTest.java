package com.indracompany.stags.test;

import java.util.List;

import com.indracompany.stags.bo.CompraBO;
import com.indracompany.stags.bo.ab.ICompraBO;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public class CompraTest {

	private static ICompraBO compraBO;
	private static ProdutoTest produtoTest;
	private static ClienteTest clienteTest;

	// static ProdutoModel produto1;
	// static ProdutoModel produto2;
	// static ProdutoModel produto3;
	static CompraModel compra1;
	static CompraModel compra2;

	static {
		compraBO = new CompraBO();
		// produto1 = new ProdutoModel("produto1", 100.0, 15.0, 10,
		// TipoProduto.BLURAY);
		// produto2 = new ProdutoModel("produto2", 40.0, 10.0, 10,
		// TipoProduto.STREAM);
		// produto3 = new ProdutoModel("produto3", 20.0, 6.0, 10,
		// TipoProduto.DVD);
		produtoTest = new ProdutoTest();
		clienteTest = new ClienteTest();

		compra1 = new CompraModel();
		compra2 = new CompraModel();

	}

	public static void vender() {
		try {
			compraBO.addlistaProduto(produtoTest.produto1, compra1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void inserir() {
		try {
			compraBO.inserir(compra1);
			compraBO.inserir(compra2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		vender();

	}

}