package com.indracompany.stags.bo.ab;

import java.util.Collection;

import com.indracompany.stags.model.ProdutoModel;

public interface IProdutoBO {

	public void inserir(ProdutoModel pModel) throws Exception;

	public void editar(ProdutoModel pModel) throws Exception;

	public void excluir(ProdutoModel pModel) throws Exception;

	public Collection<ProdutoModel> listar() throws Exception;

	public ProdutoModel buscar(ProdutoModel pModel) throws Exception;

}
