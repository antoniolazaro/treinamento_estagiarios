package com.indracompany.stags.bo.ab;

import java.util.Collection;

import com.indracompany.stags.model.ProdutoModel;
import com.indracompany.stags.model.TipoProduto;

public interface IProdutoBO {

	public void inserir(ProdutoModel pModel) throws Exception;

	public void editar(String nome, String nomeAtualizar, Double precoVenda, Double precoAluguel, Integer quantidade)
			throws Exception;

	public void excluir(String nome) throws Exception;

	public Collection<ProdutoModel> buscarPorNome(String nome);

	public ProdutoModel buscar(String nome) throws Exception;

	public TipoProduto validarTipoProduto(String tipo) throws Exception;

}