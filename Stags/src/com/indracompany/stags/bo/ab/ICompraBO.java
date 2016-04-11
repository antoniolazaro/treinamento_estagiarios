package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraBO {

	public Double vender(List<ProdutoModel> listaProduto) throws Exception;

	public Double alugar(List<ProdutoModel> listaProduto, Integer dias) throws Exception;

	public void inserir(CompraModel compra);

	public List<CompraModel> listar();

	public void inserirListaProdutos(ProdutoModel produtoModel, CompraModel compraModel);
}