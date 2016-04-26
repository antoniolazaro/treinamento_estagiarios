package com.indracompany.stags.bo.ab;

import java.util.List;
import com.indracompany.stags.model.MidiaModel;

public interface MidiaBOIf {
	public void inserir(MidiaModel pModel) throws Exception;
	
	public void editar(MidiaModel pModel) throws Exception;
	
	public void excluir(MidiaModel pModel) throws Exception;
	
	public List<MidiaModel> listar() throws Exception;
	
	public MidiaModel buscar(MidiaModel pModel) throws Exception;

	public MidiaModel buscarMidia(String nome) throws Exception;
	
	public void validate(MidiaModel pModel) throws Exception;
	
	public MidiaModel buscar(Long codigo) throws Exception;

	public boolean validateCampoNumero(CharSequence pModel) throws Exception;

	public String exibirMidiaPrecoVendaAluguel() throws Exception;

	public String exibirMidiaPrecoMaisBaratoCaroVendaAluguel() throws Exception;

	public String exibirHistoricoAluguelMidia(MidiaModel pModel) throws Exception;
}
