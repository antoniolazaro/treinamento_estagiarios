package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraDaoMemory implements ICompraDao {

	IProdutoDao produtoDao = new ProdutoDaoMemory();

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