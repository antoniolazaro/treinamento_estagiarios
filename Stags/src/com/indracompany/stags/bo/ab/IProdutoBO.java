package com.indracompany.stags.bo.ab;

import java.util.Map;

import com.indracompany.stags.model.ProdutoModel;

public interface IProdutoBO {

	public void inserir(ProdutoModel pModel) throws Exception;

	public void editar(ProdutoModel pModel) throws Exception;

	public void excluir(ProdutoModel pModel) throws Exception;

	public Map<Long, ProdutoModel> listar() throws Exception;

	public ProdutoModel buscar(Long codProduto) throws Exception;

	public void vender(Long codProduto, Integer quantidade) throws Exception;

	public void alugar(Long codProduto, Integer quantidade) throws Exception;
}
