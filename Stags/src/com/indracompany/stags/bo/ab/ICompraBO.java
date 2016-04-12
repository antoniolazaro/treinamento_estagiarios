package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraBO {

	public Double vender( CompraModel compra) throws Exception;

	public Double alugar(Integer dias, CompraModel compra) throws Exception;

	public void inserir(CompraModel compra) throws Exception;

	public List<CompraModel> listar();

	public void addlistaProduto(ProdutoModel produtoModel, CompraModel compraModel) throws Exception;
}