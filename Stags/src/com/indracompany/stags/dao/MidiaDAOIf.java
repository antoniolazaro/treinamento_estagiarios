package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.MidiaModel;

public interface MidiaDAOIf {
	
	public void inserir(MidiaModel pModel) throws Exception;
	
	public void editar(MidiaModel pModel) throws Exception;
	
	public void excluir(MidiaModel pModel) throws Exception;
	
	public List<MidiaModel> listar() throws Exception;
	
	public MidiaModel buscar(MidiaModel pModel) throws Exception;

	public void buscarMidia(String nome) throws Exception;
	
	public void buscar(Long codigo) throws Exception;

	public void mediaPrecoVenda() throws Exception;

	public void mediaPrecoAluguel() throws Exception;

	public void midiaMaisCaraVenda() throws Exception;

	public void midiaMaisCaraAluguel() throws Exception;

	public void midiaMaisBarataVenda() throws Exception;

	public void midiaMaisBarataAluguel() throws Exception;
}
