package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraDao {

	public Double vender(List<ProdutoModel> listaProduto);

	public Double alugar(List<ProdutoModel> listaProduto, Integer dias);

	public void inserir(CompraModel compra);

	public List<CompraModel> listar();

	public void inserirListaProdutos(ProdutoModel produtoModel, CompraModel compraModel);

}