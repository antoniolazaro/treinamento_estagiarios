package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraBO {

	public void vender(CompraModel compra) throws Exception;

	public void alugar(CompraModel compra) throws Exception;

	public List<CompraModel> listar() throws Exception;

	public void addlistaProduto(ProdutoModel produtoModel, CompraModel compraModel) throws Exception;



}