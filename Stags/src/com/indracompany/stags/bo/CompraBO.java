package com.indracompany.stags.bo;

import java.util.List;

import com.indracompany.stags.bo.ab.ICompraBO;
import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.memory.CompraDaoMemory;
import com.indracompany.stags.model.CompraModel;
import com.indracompany.stags.model.ProdutoModel;

public class CompraBO implements ICompraBO {

	private ICompraDao compraDaoMemory;

	public CompraBO() {

		compraDaoMemory = new CompraDaoMemory();

	}

	public void vender(ProdutoModel pModel, Integer quantidade) throws Exception {
		compraDaoMemory.vender(pModel, quantidade);
	}

	public void alugar(ProdutoModel pModel, Integer quantidade) throws Exception {
		compraDaoMemory.alugar(pModel, quantidade);
	}

	public void inserir(CompraModel compra) {
		try {
			validate(compra);
		} catch (Exception e) {
			// mudar
			e.printStackTrace();
		}
		compraDaoMemory.inserir(compra);
	}

	public List<CompraModel> listar() {

		return compraDaoMemory.listar();
	}

	private void validate(CompraModel compra) throws Exception {
		if (compra == null) {
			throw new Exception("Produto nulo");
		}
	}

}