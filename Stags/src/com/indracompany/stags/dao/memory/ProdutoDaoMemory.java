package com.indracompany.stags.dao.memory;

import java.util.ArrayList;
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

	@Override
	public ProdutoModel buscar(ProdutoModel pModel) {

		ProdutoModel produto = DataBase.getMapProduto().get(pModel.getCodigo());

		return produto;
	}

	public Collection<ProdutoModel> buscarPorNome(String nome) {

		Collection<ProdutoModel> listaRetorno = new ArrayList<>();
		Collection<ProdutoModel> listaProduto = DataBase.getMapProduto().values();

		for (ProdutoModel produtoModel : listaProduto) {
			if (produtoModel.getNome().startsWith(nome)) {
				if (produtoModel.getAtivo()) {
					listaRetorno.add(produtoModel);
				}
			}
		}

		return listaRetorno;
	}

}