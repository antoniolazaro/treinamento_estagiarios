package com.indracompany.stags.bo;

import java.util.Collection;

import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.memory.ProdutoDaoMemory;
import com.indracompany.stags.model.ProdutoModel;

public class ProdutoBO implements IProdutoBO {

	private IProdutoDao produtoDaoMemory;

	public ProdutoBO() {

		this.produtoDaoMemory = new ProdutoDaoMemory();
	}

	public void inserir(ProdutoModel pModel) throws Exception {
		validate(pModel);
		produtoDaoMemory.inserir(pModel);
	}

	public void editar(ProdutoModel pModel) throws Exception {
		produtoDaoMemory.editar(pModel);
	}

	public void excluir(ProdutoModel pModel) throws Exception {
		produtoDaoMemory.excluir(pModel);
	}

	public Collection<ProdutoModel> listar() throws Exception {

		return produtoDaoMemory.listar();
	}

	public ProdutoModel buscar(ProdutoModel pModel) throws Exception {

		return produtoDaoMemory.buscar(pModel);
	}

	private void validate(ProdutoModel pModel) throws Exception {
		if (pModel == null) {
			throw new Exception("Produto nulo");
		}
	}
}