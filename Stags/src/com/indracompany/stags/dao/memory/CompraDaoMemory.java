package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraDaoMemory implements ICompraDao {

	IProdutoDao produtoDao = new ProdutoDaoMemory();

	public Double alugar(Integer dias, CompraModel compra) {

		Double valor = 0.0;

		for (ProdutoModel produtoModel : compra.getListaProduto()) {
			valor += produtoModel.getPrecoAluguel() * dias;
		}

		return valor;
	}

	public Double vender(CompraModel compra) {
		Double valor = 0.0;

		for (ProdutoModel produtoModel : compra.getListaProduto()) {

			valor += produtoModel.getPrecoVenda();

		}

		return valor;

	}

	public void inserir(CompraModel compra) {
		compra.setCodigo(DataBase.getCodigoCompra());
		DataBase.getListaCompra().add(compra);
	}

	public List<CompraModel> listar() {

		return DataBase.getListaCompra();
	}

	@Override
	public void addlistaProduto(ProdutoModel produtoModel, CompraModel compraModel) {
		compraModel.getListaProduto().add(produtoModel);
	}

}