package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraDao {

	public void inserir(CompraModel compra);

	public List<CompraModel> listar();

	public void addlistaProduto(ProdutoModel produtoModel, CompraModel compraModel);

}