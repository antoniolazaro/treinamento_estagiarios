package com.indracompany.stags.bo.ab;

import java.util.List;

import com.indracompany.stags.model.CompraModel;

public interface ICompraBO {
	public void iserir(CompraModel compra);

	public CompraModel buscar(Long cod);

	public List<CompraModel> listar();

}