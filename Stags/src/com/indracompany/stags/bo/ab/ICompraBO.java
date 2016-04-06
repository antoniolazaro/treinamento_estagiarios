package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public interface ICompraBO {

	public void vender(ProdutoModel pModel, Integer quantidade) throws Exception;

	public void alugar(ProdutoModel pModel, Integer quantidade) throws Exception;

	public void inserir(CompraModel compra);

	public List<CompraModel> listar();

}