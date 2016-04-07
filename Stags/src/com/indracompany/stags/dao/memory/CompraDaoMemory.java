package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraDaoMemory implements ICompraDao {

	IProdutoDao produtoDao = new ProdutoDaoMemory();

	public Double alugar(ProdutoModel pModel, Integer quantidade, Integer dias) {

		Double valor;

		ProdutoModel produto = produtoDao.buscar(pModel);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		DataBase.getMapProduto().put(pModel.getCodigo(), produto);
		valor = pModel.getPrecoAluguel() * quantidade * dias;
		return valor;
	}

	public Double vender(ProdutoModel pModel, Integer quantidade) {
		Double valor;
		ProdutoModel produto = produtoDao.buscar(pModel);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		DataBase.getMapProduto().put(pModel.getCodigo(), produto);
		valor = pModel.getPrecoAluguel() * quantidade;
		return valor;

	}

	public void inserir(CompraModel compra) {
		compra.setCodigo(DataBase.getCodigoCompra());
		DataBase.getListaCompra().add(compra);
	}

	public List<CompraModel> listar() {

		return DataBase.getListaCompra();
	}

}