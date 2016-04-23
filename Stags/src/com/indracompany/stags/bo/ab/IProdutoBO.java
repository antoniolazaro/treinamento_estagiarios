package com.indracompany.stags.bo.ab;

import java.util.Collection;

import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public interface IProdutoBO {

	public void inserir(ProdutoModel pModel) throws Exception;

	public void editar(ProdutoModel produto) throws Exception;

	public void excluir(ProdutoModel produto) throws Exception;

	public Collection<ProdutoModel> buscarPorNome(String nome) throws Exception;

	public ProdutoModel buscar(String nome) throws Exception;

	public TipoProduto validarTipoProduto(String tipo) throws Exception;

	public void tratarSituacaoProduto(ProdutoModel produto);

	public ProdutoModel maisCaro() throws Exception;

	public ProdutoModel maisBarato() throws Exception;

}