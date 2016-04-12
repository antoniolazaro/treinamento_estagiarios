
package com.indracompany.stags.bo;

import java.util.List;
import java.util.Map.Entry;

import com.indracompany.stags.bo.ab.ICompraBO;
import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.memory.CompraDaoMemory;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraBO implements ICompraBO {

	private ICompraDao compraDaoMemory;

	public CompraBO() {

		compraDaoMemory = new CompraDaoMemory();

	}

	public Double vender(CompraModel compra) throws Exception {

		if (compra.getListaProduto().size() > 0) {

			for (ProdutoModel produtoModel : compra.getListaProduto()) {
				produtoModel.setQuantidade(produtoModel.getQuantidade() - 1);
			}

		} else {
			throw new Exception("lista Vazia");
		}
		return compraDaoMemory.vender(compra);
	}

	public Double alugar(Integer dias, CompraModel compra) throws Exception {

		if (compra.getListaProduto().size() > 0) {

			for (ProdutoModel produtoModel : compra.getListaProduto()) {
				produtoModel.setQuantidade(produtoModel.getQuantidade() - 1);

			}
		} else {
			throw new Exception("lista Vazia");
		}

		return compraDaoMemory.alugar(dias, compra);

	}

	public void inserir(CompraModel compra) throws Exception {
		validate(compra);
		compraDaoMemory.inserir(compra);
	}

	public List<CompraModel> listar() {

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

			for (Entry<Long, ProdutoModel> iterar : DataBase.getMapProduto().entrySet()) {
				if (iterar.getValue().getNome().equalsIgnoreCase(produtoModel.getNome())
						&& iterar.getValue().getAtivo() == true) {
					compraDaoMemory.addlistaProduto(produtoModel, compraModel);
				} else {
					throw new Exception("Produto Não Consta no estoque");
				}
			}
		} else {
			throw new Exception("Objetos nulos");
		}

	}

}