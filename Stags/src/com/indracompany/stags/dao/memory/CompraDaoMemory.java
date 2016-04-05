package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.CompraModel;

public class CompraDaoMemory implements ICompraDao {

	@Override
	public void iserir(CompraModel compra) {
		if (compra != null) {
			compra.setCodigo(DataBase.getCodigoCompra());
			DataBase.getListaCompra().add(compra);
		}
	}

	@Override
	public CompraModel buscar(Long cod) {
		CompraModel compraEncontrada = null;
		if (DataBase.getListaCompra().contains(cod)) {
			for (CompraModel compra : DataBase.getListaCompra()) {
				if (compra.getCodigo().equals(cod)) {
					compraEncontrada = compra;
				}
			}
		}
		return compraEncontrada;

	}

	@Override
	public List<CompraModel> listar() {
		return DataBase.getListaCompra();
	}

}