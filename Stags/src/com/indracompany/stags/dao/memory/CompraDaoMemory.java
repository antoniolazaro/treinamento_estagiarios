package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraDaoMemory implements ICompraDao {

	IProdutoDao produtoDao = new ProdutoDaoMemory();

	public void alugar(ProdutoModel pModel, Integer quantidade) {
		// lembrar de verificar posição de estoque
		ProdutoModel produto = produtoDao.buscar(pModel);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		DataBase.getMapProduto().put(pModel.getCodigo(), produto);

		// add em uma lista como aluguel
	}

	public void vender(ProdutoModel pModel, Integer quantidade) {
		// lembrar de verificar posição de estoque
		ProdutoModel produto = produtoDao.buscar(pModel);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		DataBase.getMapProduto().put(pModel.getCodigo(), produto);

		// add em uma lista como compra

	}

	public void inserir(CompraModel compra) {
		compra.setCodigo(DataBase.getCodigoCompra());
		DataBase.getListaCompra().add(compra);
	}

	public List<CompraModel> listar() {

		return DataBase.getListaCompra();
	}

}