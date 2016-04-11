package com.indracompany.stags.dao;

import java.util.Collection;

import com.indracompany.stags.model.ProdutoModel;

public interface IProdutoDao {

	public void inserir(ProdutoModel pModel);

	public void editar(ProdutoModel pModel);

	public void excluir(ProdutoModel pModel);

	public Collection<ProdutoModel> buscarPorNome(String nome);

	public ProdutoModel buscar(ProdutoModel pModel);

}