package com.indracompany.stags.dao.memory;

import java.util.List;

import com.indracompany.stags.dao.ICompraDao;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.Compra;

public class CompraDaoMemory implements ICompraDao {

	@Override
	public void iserir(Compra compra) {
		if (compra != null) {
			compra.setCodigo(DataBase.getCodigoCompra());
			DataBase.getListaCompra().add(compra);
		}
	}

	@Override
	public Compra buscar(Long cod) {
		Compra compraEncontrada = null;
		if (DataBase.getListaCompra().contains(cod)) {
			for (Compra compra : DataBase.getListaCompra()) {
				if (compra.getCodigo().equals(cod)) {
					compraEncontrada = compra;
				}
			}
		}
		return compraEncontrada;

	}

	@Override
	public List<Compra> listar() {
		return DataBase.getListaCompra();
	}

}