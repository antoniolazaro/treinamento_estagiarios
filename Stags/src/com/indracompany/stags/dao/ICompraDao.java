package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.Compra;

public interface ICompraDao {

	public void iserir(Compra compra);

	public Compra buscar(Long cod);

	public List<Compra> listar();

}