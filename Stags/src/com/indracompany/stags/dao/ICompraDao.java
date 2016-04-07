package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraDao {

	public Double vender(ProdutoModel pModel, Integer quantidade);

	public Double alugar(ProdutoModel pModel, Integer quantidade, Integer dias);

	public void inserir(CompraModel compra);

	public List<CompraModel> listar();

}