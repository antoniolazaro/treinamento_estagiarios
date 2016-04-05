package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.ICompraBO;
import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.memory.CompraDaoMemory;
import com.indracompany.stags.model.CompraModel;

public class CompraBO implements ICompraBO {

	private ICompraDao compraDaoMemory;

	public CompraBO() {

		compraDaoMemory = new CompraDaoMemory();

	}

	@Override
	public void iserir(CompraModel compra) {
		compraDaoMemory.iserir(compra);
	}

	@Override
	public CompraModel buscar(Long cod) {
		return compraDaoMemory.buscar(cod);
	}

	@Override
	public List<CompraModel> listar() {

		return compraDaoMemory.listar();
	}

}