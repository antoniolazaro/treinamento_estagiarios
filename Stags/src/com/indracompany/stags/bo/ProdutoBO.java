package com.indracompany.stags.bo;

import java.util.Map;

import com.indracompany.stags.bo.ab.IProdutoBO;
import com.indracompany.stags.dao.IProdutoDao;
import com.indracompany.stags.dao.memory.ProdutoDaoMemory;
import com.indracompany.stags.model.ProdutoModel;

public class ProdutoBO implements IProdutoBO {

	private IProdutoDao produtoDaoMemory;

	public ProdutoBO() {

		this.produtoDaoMemory = new ProdutoDaoMemory();
	}

	@Override
	public void inserir(ProdutoModel pModel) throws Exception {
		produtoDaoMemory.inserir(pModel);
	}

	@Override
	public void editar(ProdutoModel pModel) throws Exception {
		produtoDaoMemory.editar(pModel);

	}

	@Override
	public void excluir(ProdutoModel pModel) throws Exception {

		produtoDaoMemory.excluir(pModel);
	}

	@Override
	public Map<Long, ProdutoModel> listar() throws Exception {

		return produtoDaoMemory.listar();
	}

	@Override
	public ProdutoModel buscar(Long codProduto) throws Exception {

		return produtoDaoMemory.buscar(codProduto);
	}

	@Override
	public void vender(Long codProduto, Integer quantidade) throws Exception {
		produtoDaoMemory.vender(codProduto, quantidade);
	}

	@Override
	public void alugar(Long codProduto, Integer quantidade) throws Exception {

		produtoDaoMemory.alugar(codProduto, quantidade);
	}

}