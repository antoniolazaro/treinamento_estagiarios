package com.indracompany.stags.dao.memory;

import java.util.Collection;

import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ProdutoModel;

public class ProdutoDaoMemory implements IProdutoDao {

	@Override
	public void inserir(ProdutoModel pModel) {

		pModel.setCodigo(DataBase.getCodigoProduto());
		DataBase.getMapProduto().put(pModel.getCodigo(), pModel);
	}

	@Override
	public void editar(ProdutoModel pModel) {
		DataBase.getMapProduto().put(pModel.getCodigo(), pModel);

	}

	@Override
	public void excluir(ProdutoModel pModel) {
		pModel.setAtivo(false);
		DataBase.getMapProduto().put(pModel.getCodigo(), pModel);

	}

	// traz valores do produto
	@Override
	public Collection<ProdutoModel> listar() {
		return DataBase.getMapProduto().values();
	}

	@Override
	public ProdutoModel buscar(ProdutoModel pModel) {
		ProdutoModel produto = DataBase.getMapProduto().get(pModel.getCodigo());

		return produto;
	}

}