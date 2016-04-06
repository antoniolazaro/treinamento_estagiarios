package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraDao {

	public void vender(ProdutoModel pModel, Integer quantidade);

	public void alugar(ProdutoModel pModel, Integer quantidade);

	public void inserir(CompraModel compra);

	public List<CompraModel> listar();

}