package com.indracompany.stags.dao;

import java.util.List;

import com.indracompany.stags.model.MidiaModel;

public interface MidiaDAOIf {
	
	public void inserir(MidiaModel pModel) throws Exception;
	
	public void editar(MidiaModel pModel) throws Exception;
	
	public void excluir(MidiaModel pModel) throws Exception;
	
	public List<MidiaModel> listar() throws Exception;
	
	public MidiaModel buscar(MidiaModel pModel) throws Exception;

	public MidiaModel buscarMidia(String nome) throws Exception;
	
	public MidiaModel buscar(Long codigo) throws Exception;

	public Double mediaPrecoVenda() throws Exception;

	public Double mediaPrecoAluguel() throws Exception;

	public MidiaModel midiaMaisCaraVenda() throws Exception;

	public MidiaModel midiaMaisCaraAluguel() throws Exception;

	public MidiaModel midiaMaisBarataVenda() throws Exception;

	public MidiaModel midiaMaisBarataAluguel() throws Exception;

	public String exibirMidiaPrecoVendaAluguel() throws Exception;

	public String exibirMidiaPrecoMaisBaratoCaroVendaAluguel() throws Exception;
}
