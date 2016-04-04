package com.indracompany.stags.dao.memory;

import java.util.Map;

import java.util.Map.Entry;

import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.ProdutoModel;

//fazer alterações depois
public class ProdutoDaoMemory implements IProdutoDao {

	@Override
	public void inserir(ProdutoModel pModel) throws Exception {

		if (pModel != null) {
			pModel.setCodigo(DataBase.getCodigoProduto());
			DataBase.getMapProduto().put(pModel.getCodigo(), pModel);
		}
	}

	@Override
	public void editar(ProdutoModel pModel) throws Exception {
		if (pModel != null) {

			DataBase.getMapProduto().put(buscar(pModel.getCodigo()).getCodigo(), pModel);
		} else {
			throw new Exception("Produto Nulo");
		}

	}

	@Override
	public void excluir(ProdutoModel pModel) throws Exception {
		if (pModel != null) {
			pModel.setAtivo(false);
			DataBase.getMapProduto().put(buscar(pModel.getCodigo()).getCodigo(), pModel);

		} else {
			throw new Exception("Produto Nulo");
		}
	}

	@Override
	public Map<Long, ProdutoModel> listar() throws Exception {
		return null;
	}

	@Override
	public ProdutoModel buscar(Long codProduto) throws Exception {
		ProdutoModel produto = null;
		if (DataBase.getMapProduto().containsKey(codProduto)) {

			for (Entry<Long, ProdutoModel> iterar : DataBase.getMapProduto().entrySet()) {

				if (iterar.getKey().equals(codProduto) && iterar.getValue().getAtivo() == true) {
					produto = (ProdutoModel) iterar;

				}
			}

		} else {
			throw new Exception("Produto não encontrado!");

		}
		return produto;
	}

	@Override
	public void vender(Long codProduto, Integer quantidade) throws Exception {
		ProdutoModel produto = buscar(codProduto);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		DataBase.getMapProduto().put(codProduto, produto);
		// add em uma lista como compra

	}

	@Override
	public void alugar(Long codProduto, Integer quantidade) throws Exception {

		ProdutoModel produto = buscar(codProduto);
		produto.setQuantidade(produto.getQuantidade() - quantidade);
		DataBase.getMapProduto().put(codProduto, produto);

		// add em uma lista como aluguel
	}

}