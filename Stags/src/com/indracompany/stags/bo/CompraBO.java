
package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.ICompraBO;
import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.memory.CompraDaoMemory;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraBO implements ICompraBO {

	private ICompraDao compraDaoMemory;
	private IProdutoBO produtoBO;

	public CompraBO() {

		compraDaoMemory = new CompraDaoMemory();
		produtoBO = new ProdutoBO();
	}

	public void vender(CompraModel compra) throws Exception {
		Double valor = 0.0;
		for (ProdutoModel produto : compra.getListaProduto()) {

			if (produto.getAtivo() && produto.getQuantidade() > 0) {

				produto.setQuantidade(produto.getQuantidade() - 1);
				// produtoBO.editar(produto);
				valor += produto.getPrecoVenda();
			}
		}
		compra.setValorTotal(valor);
		inserir(compra);
	}

	public void alugar(CompraModel compra) throws Exception {
		Double valor = 0.0;
		for (ProdutoModel produto : compra.getListaProduto()) {
			produto.setQuantidade(produto.getQuantidade() - 1);
			// produtoBO.editar(produto);
			valor += produto.getPrecoAluguel();
		}

		valor += valor * compra.getDias();
		compra.setValorTotal(valor);
		inserir(compra);
	}

	private void inserir(CompraModel compra) throws Exception {
		validate(compra);
		compraDaoMemory.inserir(compra);
	}

	public List<CompraModel> listar() throws Exception {

		validarListaDeCompra(compraDaoMemory.listar());
		return compraDaoMemory.listar();
	}

	private void validate(CompraModel compra) throws Exception {
		if (compra == null) {
			throw new Exception("Produto nulo");
		}
	}

	@Override
	public void addlistaProduto(ProdutoModel produtoModel, CompraModel compraModel) throws Exception {
		if (produtoModel != null && compraModel != null) {

			compraDaoMemory.addlistaProduto(produtoModel, compraModel);

		} else {
			throw new Exception("Compra  nula");
		}
	}
	//
	// public void validarCompra(CompraModel compra) throws Exception {
	//
	// if (compra.getListaProduto().size() > 0) {
	//
	// for (ProdutoModel produtoModel : compra.getListaProduto()) {
	// produtoModel.setQuantidade(produtoModel.getQuantidade() - 1);
	// }
	//
	// } else {
	// throw new Exception("lista Vazia");
	// }
	// }

	private void validarListaDeCompra(List<CompraModel> listaDeCompra) throws Exception {

		if (listaDeCompra.isEmpty()) {
			throw new Exception("Não possui Compras!");
		}

	}
}